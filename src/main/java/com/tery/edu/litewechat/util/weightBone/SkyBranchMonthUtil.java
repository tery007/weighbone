package com.tery.edu.litewechat.util.weightBone;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 年天干对应的月份干支
 * ------------------------------------------------------------------------------------------------------
 * |年天干|  |正月|  |二月|  |三月|  |四月|  |五月|  |六月|  |七月|  |八月|  |九月|  |十月|  |十一月|    |十二月|
 * |甲、己|  |丙寅|  |丁卯|  |戊辰|  |己巳|  |庚午|  |辛未|  |壬申|  |癸酉|  |甲戌|  |乙亥|  |丙子|      |丁丑|
 * |乙、庚|  |戊寅|  |己卯|  |庚辰|  |辛巳|  |壬午|  |癸未|  |甲申|  |乙酉|  |丙戌|  |丁亥|  |戊子|      |己丑|
 * |丙、辛|  |庚寅|  |辛卯|  |壬辰|  |癸巳|  |甲午|  |乙未|  |丙申|  |丁酉|  |戊戌|  |己亥|  |庚子|      |辛丑|
 * |丁、壬|  |壬寅|  |癸卯|  |甲辰|  |乙巳|  |丙午|  |丁未|  |戊申|  |己酉|  |庚戌|  |辛亥|  |壬子|      |癸丑|
 * |戊、癸|  |甲寅|  |乙卯|  |丙辰|  |丁巳|  |戊午|  |己未|  |庚申|  |辛酉|  |壬戌|  |癸亥|  |甲子|      |乙丑|
 * ------------------------------------------------------------------------------------------------------
 * Created by wanglei on 2018/11/12 下午3:27
 **/
public class SkyBranchMonthUtil {

    public static String getSkybranchMonth(String yearSkyBranch,Integer month) {
        if (StringUtils.isEmpty(yearSkyBranch)) {
            return null;
        }
        if (StringUtils.equals(yearSkyBranch, "甲") || StringUtils.equals(yearSkyBranch, "己")) {
            return jiaJiMap.get(String.valueOf(month));
        } else if (StringUtils.equals(yearSkyBranch, "乙") || StringUtils.equals(yearSkyBranch, "庚")) {
            return yiGengMap.get(String.valueOf(month));
        } else if (StringUtils.equals(yearSkyBranch, "丙") || StringUtils.equals(yearSkyBranch, "辛")){
            return bingXinMap.get(String.valueOf(month));
        } else if (StringUtils.equals(yearSkyBranch, "丁") || StringUtils.equals(yearSkyBranch, "壬")) {
            return dingRenMap.get(String.valueOf(month));
        } else if (StringUtils.equals(yearSkyBranch, "戊") || StringUtils.equals(yearSkyBranch, "癸")) {
            return wuGuiMap.get(String.valueOf(month));
        }
        return null;
    }

    public static final Map<String, String> jiaJiMap = new HashMap<>();

    public static final Map<String, String> yiGengMap = new HashMap<>();

    public static final Map<String, String> bingXinMap = new HashMap<>();

    public static final Map<String, String> dingRenMap = new HashMap<>();

    public static final Map<String, String> wuGuiMap = new HashMap<>();

    static {
        jiaJiMap.put("1", "丙寅");
        jiaJiMap.put("2", "丁卯");
        jiaJiMap.put("3", "戊辰");
        jiaJiMap.put("4", "己巳");
        jiaJiMap.put("5", "庚午");
        jiaJiMap.put("6", "辛未");
        jiaJiMap.put("7", "壬申");
        jiaJiMap.put("8", "癸酉");
        jiaJiMap.put("9", "甲戌");
        jiaJiMap.put("10", "乙亥");
        jiaJiMap.put("11", "丙子");
        jiaJiMap.put("12", "丁丑");

        yiGengMap.put("1", "戊寅");
        yiGengMap.put("2", "己卯");
        yiGengMap.put("3", "庚辰");
        yiGengMap.put("4", "辛巳");
        yiGengMap.put("5", "壬午");
        yiGengMap.put("6", "癸未");
        yiGengMap.put("7", "甲申");
        yiGengMap.put("8", "乙酉");
        yiGengMap.put("9", "丙戌");
        yiGengMap.put("10", "丁亥");
        yiGengMap.put("11", "戊子");
        yiGengMap.put("12", "己丑");

        bingXinMap.put("1", "庚寅");
        bingXinMap.put("2", "辛卯");
        bingXinMap.put("3", "壬辰");
        bingXinMap.put("4", "癸巳");
        bingXinMap.put("5", "甲午");
        bingXinMap.put("6", "乙未");
        bingXinMap.put("7", "丙申");
        bingXinMap.put("8", "丁酉");
        bingXinMap.put("9", "戊戌");
        bingXinMap.put("10", "己亥");
        bingXinMap.put("11", "庚子");
        bingXinMap.put("12", "辛丑");


        dingRenMap.put("1", "壬寅");
        dingRenMap.put("2", "癸卯");
        dingRenMap.put("3", "甲辰");
        dingRenMap.put("4", "乙巳");
        dingRenMap.put("5", "丙午");
        dingRenMap.put("6", "丁未");
        dingRenMap.put("7", "戊申");
        dingRenMap.put("8", "己酉");
        dingRenMap.put("9", "庚戌");
        dingRenMap.put("10", "辛亥");
        dingRenMap.put("11", "壬子");
        dingRenMap.put("12", "癸丑");

        wuGuiMap.put("1", "甲寅");
        wuGuiMap.put("2", "乙卯");
        wuGuiMap.put("3", "丙辰");
        wuGuiMap.put("4", "丁巳");
        wuGuiMap.put("5", "戊午");
        wuGuiMap.put("6", "己未");
        wuGuiMap.put("7", "庚申");
        wuGuiMap.put("8", "辛酉");
        wuGuiMap.put("9", "壬戌");
        wuGuiMap.put("10", "癸亥");
        wuGuiMap.put("11", "甲子");
        wuGuiMap.put("12", "乙丑");
        
        
        
    }


}
