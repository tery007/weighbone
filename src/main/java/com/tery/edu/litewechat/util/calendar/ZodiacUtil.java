package com.tery.edu.litewechat.util.calendar;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wanglei on 2018/11/10 下午3:28
 **/
@Slf4j
public class ZodiacUtil {

    public static String getZodiac(Integer year){
        if(year<1900){
            return "未知";
        }
        Integer start=1900;
        String [] years=new String[]{
                "鼠","牛","虎","兔",
                "龙","蛇","马","羊",
                "猴","鸡","狗","猪"
        };
        return years[(year-start)%12];
    }

}
