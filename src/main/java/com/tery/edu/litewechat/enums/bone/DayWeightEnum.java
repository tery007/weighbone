package com.tery.edu.litewechat.enums.bone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/20 下午11:24
 **/
@Getter
@AllArgsConstructor
public enum  DayWeightEnum {

    ONE(1,0.5),
    TWO(2, 1.0),
    THREE(3, 0.8),
    FOUR(4, 1.5),
    FIVE(5, 1.6),
    SIX(6, 1.5),
    SEVEN(7, 0.8),
    EIGHT(8, 1.6),
    NINE(9, 0.8),
    TEN(10, 1.6),
    ELEVEN(11, 0.9),
    TWELVE(12, 1.7),
    THIRTEEN(13, 0.8),
    FOURTEEN(14, 1.7),
    FIFTEEN(15, 1.0),
    SIXTEEN(16, 0.8),
    SEVENTEEN(17, 0.9),
    EIGHTTEEN(18, 1.8),
    NINETEEN(19, 0.5),
    TWENTY(20, 1.5),
    TWENTYONE(21, 1.0),
    TWENTYTWO(22, 0.9),
    TWENTYTHREE(23, 0.8),
    TWENTYFOUR(24, 0.9),
    TWENTYFIVE(25, 1.5),
    TWENTYSIX(26, 1.8),
    TWENTYSEVEN(27, 0.7),
    TWENTYEIGHT(28, 0.8),
    TWENTYNINE(29, 1.6),
    THIRTY(30, 0.6),
    ;
    private Integer name;
    private Double value;


    public static Map<Integer, DayWeightEnum> dayWeightEnumMap;

    static {
        dayWeightEnumMap = Arrays.asList(DayWeightEnum.values())
                .stream().collect(Collectors.toMap(DayWeightEnum::getName, a -> a));
    }

}
