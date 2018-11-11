package com.tery.edu.litewechat.domain.weightBone;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wanglei on 2018/10/18 上午10:37
 **/
@Getter
@Setter
public class BoneInfo {

    /**
     * 骨重
     */
    private Double boneWeightValue;
    /**
     * 骨重（市斤）
     */
    private String boneWeight;

    /**
     * 骨重代表的信息
     */
    private String boneWeightInfo;

    private String boneInfo;
    private String boneInfoBZ;
    private String boneInfoSep;

    /**
     * 生辰八字
     */
    private String name;
    private String sex;
    private String age;
    //属相
    private String shuXiang;

    /**
     * 公历生日信息
     */
    private String glBirthday;
    private String glYear;
    private String glMonth;
    private String glDay;
    private String glHour;
    private String glMinute;

    /**
     * 阴历生日信息
     */
    private String ylYear;
    private String ylMonth;
    private String ylDay;
    private String ylHour;

    /**
     * 八字
     */
    //天干地支
    private String yearTD;
    //月份
    private String monthBZ;
    //日
    private String dayBZ;
    //时辰
    private String hourBZ;


    @Override
    public String toString() {
        return "BoneInfo{" +
                "boneWeightValue=" + boneWeightValue +
                ", boneWeight='" + boneWeight + '\'' +
                ", boneWeightInfo='" + boneWeightInfo + '\'' +
                ", boneInfo='" + boneInfo + '\'' +
                ", boneInfoBZ='" + boneInfoBZ + '\'' +
                ", boneInfoSep='" + boneInfoSep + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", shuXiang='" + shuXiang + '\'' +
                ", glBirthday='" + glBirthday + '\'' +
                ", glYear='" + glYear + '\'' +
                ", glMonth='" + glMonth + '\'' +
                ", glDay='" + glDay + '\'' +
                ", glHour='" + glHour + '\'' +
                ", glMinute='" + glMinute + '\'' +
                ", ylYear='" + ylYear + '\'' +
                ", ylMonth='" + ylMonth + '\'' +
                ", ylDay='" + ylDay + '\'' +
                ", ylHour='" + ylHour + '\'' +
                ", yearTD='" + yearTD + '\'' +
                ", monthBZ='" + monthBZ + '\'' +
                ", dayBZ='" + dayBZ + '\'' +
                ", hourBZ='" + hourBZ + '\'' +
                '}';
    }
}
