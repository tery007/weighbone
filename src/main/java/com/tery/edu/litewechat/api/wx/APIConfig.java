package com.tery.edu.litewechat.api.wx;

import com.alibaba.fastjson.JSONObject;
import com.tery.edu.litewechat.constants.WechatConstants;
import com.tery.edu.litewechat.domain.GetAccessTokenResponse;
import com.tery.edu.litewechat.util.cache.RedisTemplateUtil;
import com.tery.edu.litewechat.util.json.JSONUtil;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by wanglei on 2018/7/21 下午11:40
 **/
@Slf4j
@Getter
@ToString(callSuper = true)
public final class APIConfig {

    /**
     * 微信刷新token的锁
     */
    private static final String WEIXIN_REFRESH_TOKEN_LOCK_PREFIX     = "fastweixin:token:refresh:lock";

    private final AtomicBoolean tokenRefreshing = new AtomicBoolean(false);

    private RedisTemplateUtil redisTemplateUtil;

    private final String appId;
    private final String secret;

    private long                weixinTokenStartTime;


    public APIConfig(String appId, String secret,RedisTemplateUtil template) {
        this.redisTemplateUtil = template;
        this.appId = appId;
        this.secret = secret;
    }

    public String getAccessToken() {

        Optional<String> token = this.getTokenFromRedis();
        if (token.isPresent()) {
            return token.get();
        }

        //timeout设置为0秒，即只获取一次锁（可以获取则无锁，未获取到则说明有服务正在刷新）
        if (redisTemplateUtil.lock(WEIXIN_REFRESH_TOKEN_LOCK_PREFIX, 0L,3L)) {
            initToken(7100L);
        }

        long currentTimeMills = System.currentTimeMillis();
        do {
            token = getTokenFromRedis();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((System.currentTimeMillis() - currentTimeMills) < 4 * 1000 && !token.isPresent());

        if (token.isPresent()) {
            return token.get();
        }

        if (redisTemplateUtil.lock(WEIXIN_REFRESH_TOKEN_LOCK_PREFIX, 0L, 3L)) {
            initToken(7100L);
        }

        token = getTokenFromRedis();
        if (token.isPresent()) {
            return token.get();
        }

        throw new RuntimeException("do not get token from redis");

    }

    private Optional<String> getTokenFromRedis() {
        String token = this.redisTemplateUtil.get("fastweixin:token:value");
        return StringUtils.isEmpty(token) ? Optional.empty() : Optional.of(token);
    }

    /**
     * 项目启动时，初始化token
     *
     * @param refreshTime
     */
    private void initToken(final long refreshTime) {
        final long oldTime = this.weixinTokenStartTime;

        this.weixinTokenStartTime = refreshTime;

        String url = WechatConstants.ACCESS_TOKEN_URL
                .replace("APPID", this.getAppId())
                .replace("APPSECRET", this.getSecret());

        RestTemplate template = new RestTemplate();

        JSONObject response = template.getForObject(url, JSONObject.class);

        GetAccessTokenResponse tokenResponse = JSONUtil.toBean(response, GetAccessTokenResponse.class);

        if (StringUtils.isEmpty(tokenResponse.getAccessToken())) {

            this.weixinTokenStartTime = oldTime;

            throw new RuntimeException("获取微信access_token错误：" + tokenResponse.getErrcode() + "," + tokenResponse.getErrmsg());
        }

        redisTemplateUtil.set("fastweixin:token:value", tokenResponse.getAccessToken(), refreshTime);

        log.info("获取access_token:" + tokenResponse);

        this.tokenRefreshing.set(false);
    }
}
