package com.tery.edu.litewechat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/11/13 上午11:28
 **/
@Getter
@AllArgsConstructor
public enum  MonthBaseNumEnum {

    ONE(1,0),
    TWO(2,31),
    THREE(3,-1),
    FOUR(4,30),
    FIVE(5,0),
    SIX(6,31),
    SEVEN(7,1),
    EIGHT(8,32),
    NINE(9,3),
    TEN(10,33),
    ELVEN(11,4),
    TWELVE(12,34),;


    private Integer month;
    private Integer baseNum;

    public static Map<Integer, Integer> monthBaseMap;

    static {
        monthBaseMap = Arrays.asList(MonthBaseNumEnum.values())
                .stream()
                .collect(Collectors.toMap(MonthBaseNumEnum::getMonth, MonthBaseNumEnum::getBaseNum));
    }


}
