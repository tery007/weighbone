package com.tery.edu.litewechat;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.util.RedisTemplateUtil;
import com.tery.edu.litewechat.constants.WechatConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@Slf4j
@ImportResource(locations = "classpath:applicationContext.xml")
@SpringBootApplication
@EnableDiscoveryClient
public class LitewechatApplication {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ApiConfig apiConfig(@Qualifier("cacheUtilWxServer")RedisTemplateUtil redisTemplateUtil) {
        ApiConfig config = new ApiConfig(WechatConstants.APP_ID, WechatConstants.SECRET,true,redisTemplateUtil);
        String accessToken = config.getAccessToken();
        log.info("application init access_token:" + accessToken);
        return config;
    }

    @Bean
    public OauthAPI newOauthAPI(ApiConfig apiConfig) {
        return new OauthAPI(apiConfig);
    }

	public static void main(String[] args) {
		SpringApplication.run(LitewechatApplication.class, args);
	}
}
