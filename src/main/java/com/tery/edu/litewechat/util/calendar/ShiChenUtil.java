package com.tery.edu.litewechat.util.calendar;

/**
 * Created by wanglei on 2018/10/21 上午12:24
 **/
public class ShiChenUtil {

    /**
     * 小时转时辰
     * @param hour
     * @return
     */
    public static String convert2SC(String hour) {
        Integer time = Integer.valueOf(hour);
        if (1 <= time && time < 3) {
            return "丑时";
        } else if (3 <= time && time < 5) {
            return "寅时";
        } else if (5 <= time && time < 7) {
            return "卯时";
        }else if (7 <= time && time < 9) {
            return "辰时";
        }else if (9 <= time && time < 11) {
            return "巳时";
        }else if (11 <= time && time < 13) {
            return "午时";
        }else if (13 <= time && time < 15) {
            return "未时";
        }else if (15 <= time && time < 17) {
            return "申时";
        }else if (17 <= time && time < 19) {
            return "酉时";
        }else if (19 <= time && time < 21) {
            return "戌时";
        }else if (21 <= time && time < 23) {
            return "亥时";
        }else {
            return "子时";
        }
    }
}
