package com.tery.edu.litewechat.util.weightBone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanglei on 2018/10/18 上午10:39
 **/
public class WeightBoneInitUtil {

    /**
     * 年区间
     * [1932年-2018年]
     *
     * @return
     */
    public static List<String> initYears() {
        List<String> years = new ArrayList<>();
        for (int year = 1932; year <= 2018; year++) {
            years.add("" + year);
        }
        return years;
    }

    /**
     * 月区间
     * [1,12]
     *
     * @return
     */
    public static List<String> initMonths() {
        List<String> months = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            months.add("" + month);
        }
        return months;
    }

    /**
     * 日区间
     * [1,31]，未与月份进行联动
     *
     * @return
     */
    public static List<String> initDays() {
        List<String> days = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            days.add("" + day);
        }
        return days;
    }

    /**
     * 小时区间
     * [0,23]
     *
     * @return
     */
    public static List<String> initHours() {
        List<String> hours = new ArrayList<>();
        for (int hour = 0; hour <= 23; hour++) {
            hours.add("" + hour);
        }
        return hours;
    }

    /**
     * 分钟区间
     * [0,59]
     *
     * @return
     */
    public static List<String> initMinutes() {
        List<String> minutes = new ArrayList<>();
        for (int minute = 0; minute <= 59; minute++) {
            minutes.add("" + minute);
        }
        return minutes;
    }

    public static String boneWeight(Double weight) {
        if (weight <= 0.0) {
            return null;
        }
        String value = String.valueOf(weight);
        String interalVal = value.substring(0, value.indexOf('.'));
        String decimalVal = value.substring(value.indexOf('.') + 1);
        if (Integer.valueOf(interalVal) > 0) {
            interalVal = interalVal + "两";
        }
        if (Integer.valueOf(decimalVal) > 0) {
            decimalVal += "钱";
        } else {
            decimalVal = "";
        }
        return interalVal + decimalVal;
    }




//    public static final Map<String, Double> yearWeightMap = new HashMap<>();
//    public static final Map<String, Double> monthWeightMap = new HashMap<>();
//    public static final Map<String, Double> dayWeightMap = new HashMap<>();
//    static {
//        yearWeightMap.put("甲子", 1.2);
//        yearWeightMap.put("丙子", 1.6);
//        yearWeightMap.put("戊子", 1.5);
//        yearWeightMap.put("庚子", 0.7);
//        yearWeightMap.put("壬子", 0.5);
//        yearWeightMap.put("乙丑", 0.9);
//        yearWeightMap.put("丁丑", 0.8);
//        yearWeightMap.put("己丑", 0.7);
//        yearWeightMap.put("辛丑", 0.7);
//        yearWeightMap.put("癸丑", 0.7);
//        yearWeightMap.put("丙寅", 0.6);
//        yearWeightMap.put("戊寅", 0.8);
//        yearWeightMap.put("庚寅", 0.9);
//        yearWeightMap.put("壬寅", 0.9);
//        yearWeightMap.put("甲寅", 1.2);
//        yearWeightMap.put("丁卯", 0.7);
//        yearWeightMap.put("己卯", 1.9);
//        yearWeightMap.put("辛卯", 1.2);
//        yearWeightMap.put("癸卯", 1.2);
//        yearWeightMap.put("乙卯", 1.9);
//        yearWeightMap.put("戊辰", 1.2);
//        yearWeightMap.put("庚辰", 1.2);
//        yearWeightMap.put("壬辰", 1.0);
//        yearWeightMap.put("甲辰", 0.8);
//        yearWeightMap.put("丙辰", 0.8);
//        yearWeightMap.put("己巳", 0.5);
//        yearWeightMap.put("辛巳", 0.6);
//        yearWeightMap.put("癸巳", 0.7);
//        yearWeightMap.put("乙巳", 0.7);
//        yearWeightMap.put("丁巳", 0.6);
//        yearWeightMap.put("庚午", 0.9);
//        yearWeightMap.put("壬午", 0.8);
//        yearWeightMap.put("甲午", 1.5);
//        yearWeightMap.put("丙午", 1.3);
//        yearWeightMap.put("戊午", 1.9);
//        yearWeightMap.put("辛未", 0.8);
//        yearWeightMap.put("癸未", 0.8);
//        yearWeightMap.put("乙未", 0.6);
//        yearWeightMap.put("丁未", 0.5);
//        yearWeightMap.put("己未", 0.6);
//        yearWeightMap.put("壬申", 0.7);
//        yearWeightMap.put("甲申", 0.5);
//        yearWeightMap.put("丙申", 0.5);
//        yearWeightMap.put("戊申", 1.4);
//        yearWeightMap.put("庚申", 0.8);
//        yearWeightMap.put("癸酉", 0.8);
//        yearWeightMap.put("乙酉", 1.5);
//        yearWeightMap.put("丁酉", 1.4);
//        yearWeightMap.put("己酉", 0.5);
//        yearWeightMap.put("辛酉", 1.6);
//        yearWeightMap.put("甲戌", 1.5);
//        yearWeightMap.put("丙戌", 0.6);
//        yearWeightMap.put("戊戌", 1.4);
//        yearWeightMap.put("庚戌", 0.9);
//        yearWeightMap.put("壬戌", 1.0);
//        yearWeightMap.put("乙亥", 0.9);
//        yearWeightMap.put("丁亥", 1.6);
//        yearWeightMap.put("己亥", 0.9);
//        yearWeightMap.put("辛亥", 1.7);
//        yearWeightMap.put("癸亥", 0.7);
//    }

}
