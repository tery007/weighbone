package com.tery.edu.litewechat.api.common;

import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanglei on 2018/7/23 下午3:15
 **/
@Slf4j
@RestController
@RequestMapping("/api/test")
public class CommonController extends WeixinSupport {

    @Autowired
    private ApiConfig apiConfig;

    @Override
    @PostMapping(value = "/getToken")
    protected String getToken() {
        return apiConfig.getAccessToken();
    }

    @PostMapping(value = "/bindServer")
    public void bindServer(HttpServletRequest request, HttpServletResponse response) {
        super.bindServer(request, response);

    }

}
