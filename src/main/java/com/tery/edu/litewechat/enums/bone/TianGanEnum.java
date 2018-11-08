package com.tery.edu.litewechat.enums.bone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/20 下午11:48
 **/
@Getter
@AllArgsConstructor
public enum TianGanEnum {

    JIA(1, "甲"),
    YI(2, "乙"),
    BING(3, "丙"),
    DING(4, "丁"),
    WU(5, "戊"),
    JI(6, "己"),
    GEGN(7, "庚"),
    XIN(8, "辛"),
    REN(9, "壬"),
    GUI(10, "癸"),;
    private Integer name;
    private String value;

    public static Map<Integer, TianGanEnum> tianGanEnumMap;

    static {
        tianGanEnumMap = Arrays.asList(TianGanEnum.values())
                .stream().collect(Collectors.toMap(TianGanEnum::getName, a -> a));
    }


    }
