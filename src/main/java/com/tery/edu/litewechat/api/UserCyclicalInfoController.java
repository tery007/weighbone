package com.tery.edu.litewechat.api;

import com.alibaba.fastjson.JSONObject;
import com.tery.edu.litewechat.domain.Lunar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @author wanglei
 * @description
 * @date Created on 2019/2/20
 **/
@RestController
@RequestMapping("/api/cyclical")
public class UserCyclicalInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{birthDay}",method = RequestMethod.GET)
    public String getUserCyclicalInfo(@PathVariable("birthDay") String birthDay) {
        Lunar l = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            long dateToSecond = format.parse(birthDay).getTime();
            l = new Lunar(dateToSecond);
        } catch (Exception e) {
            return "日期格式为yyyyMMdd HH，如20180109";
        }
        if (Objects.isNull(l)) {
            return null;
        }
        return l.toString();
    }

    @RequestMapping(value = "/jpa/{userId}",method = RequestMethod.GET)
    public String getUserByJpa(@PathVariable("userId") String userId) {
        long startTime = System.nanoTime();
        ResponseEntity resp = restTemplate.getForEntity("http://usengine/api/user/get/" + userId, JSONObject.class);
        long timeTaken = System.nanoTime() - startTime;
        return JSONObject.toJSONString(resp.getBody()) + ",time:" + timeTaken;
    }

    @RequestMapping(value = "/es/{userId}", method = RequestMethod.GET)
    public String getUserByEs(@PathVariable("userId") String userId) {
        long startTime = System.nanoTime();
        ResponseEntity resp = restTemplate.getForEntity("http://usengine/user/get/" + userId, JSONObject.class);
        long timeTaken = System.nanoTime() - startTime;
        return JSONObject.toJSONString(resp.getBody()) + ",time:" + timeTaken;
    }


}
