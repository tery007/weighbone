package com.tery.edu.litewechat.domain.weightBone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by wanglei on 2018/10/18 上午10:37
 **/
@Getter
@Setter
@ToString(callSuper = true)
public class BoneInfo {

    /**
     * 骨重
     */
    private Double boneWeight;
    /**
     * 生辰八字
     */
    public static class Info{
        private String name;
        private String sex;
        //属相
        private String shuXiang;

        /**
         * 公历生日信息
         */
        private String glNian;
        private String glYue;
        private String glRi;
        private String glShi;

        /**
         * 阴历生日信息
         */
        private String ylNian;
        private String ylYue;
        private String ylRi;
        private String ylShi;

        /**
         * 八字
         */
        //天干地支
        private String yearTD;
        //月份
        private String month;
        //日
        private String day;
        //时辰
        private String hourSC;

    }
}
