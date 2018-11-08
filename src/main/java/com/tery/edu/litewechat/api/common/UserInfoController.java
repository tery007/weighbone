package com.tery.edu.litewechat.api.common;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.tery.edu.litewechat.domain.weightBone.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by wanglei on 2018/10/7 下午11:56
 **/
@Slf4j
@Controller
@RequestMapping("/view")
public class UserInfoController {
    @Autowired
    private OauthAPI oauthAPI;

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam(value = "code", required = false) String code,
                              HttpServletRequest request) {

        try {
            log.info("request uri:" + request.getRequestURI());
            OauthGetTokenResponse response = oauthAPI.getToken(code);
            if (Objects.nonNull(response) && StringUtils.isEmpty(response.getErrcode())) {
                response.getRefreshToken();
                GetUserInfoResponse userInfoResponse = oauthAPI.getUserInfo(response.getAccessToken(), response.getOpenid());
                log.info(userInfoResponse.getNickname() + "," + userInfoResponse.getHeadimgurl() + "," + userInfoResponse.getCity());
            }
            return "weightBone2";
        } catch (Exception e) {
            log.error("==>get user info error:" + e);
            return "weightBone2";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/init", method = RequestMethod.POST)
    public Object initUser(@ModelAttribute UserReq userReq) {
        log.info("用户请求数据：" + userReq.toString());
        return null;
    }
}
