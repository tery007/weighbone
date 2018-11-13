package com.tery.edu.litewechat.util.weightBone;

import java.util.Objects;

/**
 * Created by wanglei on 2018/11/13 上午11:43
 **/
public class CentryConstantUtil {

    /**
     * 传递年，输出世纪常数
     * @param year
     * @return
     */
    public static Integer getCentryConstant(Integer year) {
        if (Objects.isNull(year)) {
            return null;
        }
        if (year >= 1901 && year <= 2000) {
            return 15;
        }
        if (year >= 2001 && year <= 2100) {
            return 0;
        }

        return null;

    }

}
