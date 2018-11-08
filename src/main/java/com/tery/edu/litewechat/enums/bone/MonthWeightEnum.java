package com.tery.edu.litewechat.enums.bone;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/20 下午5:10
 **/
@Getter
public enum MonthWeightEnum {

    JANUARY(1, 0.6),
    FEBRUARY(2, 0.7),
    MARCH(3, 1.8),
    APRIL(4, 0.9),
    MAY(5, 0.5),
    JUNE(6, 1.6),
    JULY(7, 0.9),
    AUGUST(8, 1.5),
    SEPTEMBER(9, 1.8),
    OCTOBER(10, 0.8),
    NOVEMBER(11, 0.9),
    DECEMBER(12, 0.5),;

    private Integer name;
    private Double  value;

    MonthWeightEnum(Integer name, Double value) {
        this.name = name;
        this.value = value;
    }

    public static Map<Integer, MonthWeightEnum> monthWeightEnumMap;

    static {
        monthWeightEnumMap = Arrays.asList(MonthWeightEnum.values())
                .stream().collect(Collectors.toMap(MonthWeightEnum::getName, a -> a));
    }
}
