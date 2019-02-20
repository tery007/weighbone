package com.tery.edu.litewechat.api;

import com.tery.edu.litewechat.domain.Lunar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
