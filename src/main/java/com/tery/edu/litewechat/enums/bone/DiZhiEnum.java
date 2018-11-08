package com.tery.edu.litewechat.enums.bone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanglei on 2018/10/20 下午11:51
 **/
@Getter
@AllArgsConstructor
public enum DiZhiEnum {

    ZI(1, "子"),
    CHOU(2, "丑"),
    MIN(3, "寅"),
    MOU(4, "卯"),
    CHEN(5, "辰"),
    SI(6, "巳"),
    WU(7, "午"),
    WEI(8, "未"),
    SHEN(9, "申"),
    YOU(10, "酉"),
    XU(11, "戌"),
    HAI(12, "亥"),;

    private Integer name;
    private String value;

    public static Map<Integer, DiZhiEnum> diZhiEnumMap;

    static {
        diZhiEnumMap = Arrays.asList(DiZhiEnum.values())
                .stream().collect(Collectors.toMap(DiZhiEnum::getName, a -> a));
    }
    }
