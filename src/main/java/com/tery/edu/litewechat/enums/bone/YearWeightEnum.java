package com.tery.edu.litewechat.enums.bone;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/20 下午4:44
 **/
@Getter
public enum YearWeightEnum {

    JIAZI("甲子", 1.2),
    BINGZI("丙子", 1.6),
    WUZI("戊子", 1.5),
    GENGZI("庚子", 0.7),
    RENZI("壬子", 0.5),
    YICHOU("乙丑", 0.9),
    DINGCHOU("丁丑", 0.8),
    JICHOU("己丑", 0.7),
    XINCHOU("辛丑", 0.7),
    GUICHOU("癸丑", 0.7),
    BINGMING("丙寅", 0.6),
    WUMING("戊寅", 0.8),
    GEGNMING("庚寅", 0.9),
    RENMING("壬寅", 0.9),
    JIAMING("甲寅", 1.2),
    DINGMOU("丁卯", 0.7),
    JIMOU("己卯", 1.9),
    XINMOU("辛卯", 1.2),
    GUIMOU("癸卯", 1.2),
    YIMOU("乙卯", 1.9),
    WUCHEN("戊辰", 1.2),
    GENGCHEN("庚辰", 1.2),
    RENCHEN("壬辰", 1.0),
    JIACHEN("甲辰", 0.8),
    BINGCHEN("丙辰", 0.8),
    JISI("己巳", 0.5),
    XINSI("辛巳", 0.6),
    GUISI("癸巳", 0.7),
    YISI("乙巳", 0.7),
    DINGSI("丁巳", 0.6),
    GENGWU("庚午", 0.9),
    RENWU("壬午", 0.8),
    JIAWU("甲午", 1.5),
    BINGWU("丙午", 1.3),
    WUWU("戊午", 1.9),
    XINWEI("辛未", 0.8),
    GUIWEI("癸未", 0.7),
    YIWEI("乙未", 0.6),
    DINGWEI("丁未", 0.5),
    JIWEI("己未", 0.6),
    RENSHEN("壬申", 0.7),
    JIASHEN("甲申", 0.5),
    BINGSHEN("丙申", 0.5),
    XUSHEN("戊申", 1.4),
    GENGSHEN("庚申", 0.8),
    GUIYOU("癸酉", 0.8),
    YIYOU("乙酉", 1.5),
    DINGYOU("丁酉", 1.4),
    JIYOU("己酉", 0.5),
    XINYOU("辛酉", 1.6),
    JIAXU("甲戌", 1.5),
    BINGXU("丙戌", 0.6),
    WUXU("戊戌", 1.4),
    GENGXU("庚戌", 0.9),
    RENXU("壬戌", 1.0),
    YIHAI("乙亥", 0.9),
    DINGHAI("丁亥", 1.6),
    JIHAI("己亥", 0.9),
    XINHAI("辛亥", 1.7),
    GUIHAI("癸亥", 0.7);

    private String name;
    private Double value;

    YearWeightEnum(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public static Map<String, YearWeightEnum> yearWeightMap;

    static {
        yearWeightMap = Arrays.asList(YearWeightEnum.values()).stream()
                .collect(Collectors.toMap(YearWeightEnum::getName, a -> a));
    }

}
