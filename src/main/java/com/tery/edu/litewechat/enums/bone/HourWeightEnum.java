package com.tery.edu.litewechat.enums.bone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/22 上午10:04
 **/
@Getter
@AllArgsConstructor
public enum HourWeightEnum {

    ZISHI("子时", 1.6),
    CHOUSHI("丑时", 0.6),
    MINGSHI("寅时", 0.7),
    MOUSHI("卯时", 1.0),
    CHENSHI("辰时", 0.9),
    SISHI("巳时", 1.6),
    WUSHI("午时", 1.0),
    WEISHI("未时", 0.8),
    SHENSHI("申时", 0.8),
    YOUSHI("酉时", 0.9),
    XUSHI("戌时", 0.6),
    HAISHI("亥时", 0.6),;

    private String name;
    private Double value;

    public static Map<String, HourWeightEnum> hourWeightEnumMap;

    static {
        hourWeightEnumMap = Arrays.asList(HourWeightEnum.values())
                .stream().collect(Collectors.toMap(HourWeightEnum::getName, a -> a));
    }


}
