package com.tery.edu.litewechat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanglei
 * @description
 * @date Created on 2019/3/7
 **/
@RestController
public class Ping {

    @RequestMapping(value = "/health-check", method = RequestMethod.GET)
    public String healthCheck() {
        return "check";
    }
}
