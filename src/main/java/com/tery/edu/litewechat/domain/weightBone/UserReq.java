package com.tery.edu.litewechat.domain.weightBone;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by wanglei on 2018/10/10 下午6:10
 **/
@Getter
@Setter
public class UserReq {

    private Integer gender;
    private String userName;
    private List<String> years;
    private List<String> months;
    private List<String> days;
    private List<String> hours;
    private List<String> minutes;
    private String bYear;
    private String bMonth;
    private String bDay;
    private String bHour;
    private String bMinute;

    private String birthdayDate;
    private String birthdayTime;

    @Override
    public String toString() {
        return "UserReq{" +
                "gender=" + gender +
                ", userName='" + userName + '\'' +
                ", years=" + years +
                ", months=" + months +
                ", days=" + days +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", bYear='" + bYear + '\'' +
                ", bMonth='" + bMonth + '\'' +
                ", bDay='" + bDay + '\'' +
                ", bHour='" + bHour + '\'' +
                ", bMinute='" + bMinute + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                ", birthdayTime='" + birthdayTime + '\'' +
                '}';
    }
}
