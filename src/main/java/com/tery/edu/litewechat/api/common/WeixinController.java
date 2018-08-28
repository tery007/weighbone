package com.tery.edu.litewechat.api.common;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.tery.edu.litewechat.constants.WechatConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanglei on 2018/7/23 下午3:15
 **/
@Slf4j
@RestController
@RequestMapping("/weixin")
public class WeixinController extends WeixinControllerSupport {

    @Autowired
    private ApiConfig apiConfig;

    @Override
    protected String getToken() {
        return WechatConstants.TOKEN;
    }

}
