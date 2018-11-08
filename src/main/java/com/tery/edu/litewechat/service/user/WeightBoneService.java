package com.tery.edu.litewechat.service.user;

import com.tery.edu.litewechat.domain.weightBone.BoneInfo;
import com.tery.edu.litewechat.domain.weightBone.UserReq;
import com.tery.edu.litewechat.enums.bone.DayWeightEnum;
import com.tery.edu.litewechat.enums.bone.HourWeightEnum;
import com.tery.edu.litewechat.enums.bone.MonthWeightEnum;
import com.tery.edu.litewechat.enums.bone.YearWeightEnum;
import com.tery.edu.litewechat.util.calendar.CalendarUtil;
import com.tery.edu.litewechat.util.calendar.ShiChenUtil;
import com.tery.edu.litewechat.util.weightBone.WeightBoneInitUtil;
import com.tery.edu.litewechat.util.weightBone.WeightBoneUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 2018/10/18 上午9:51
 **/
@Slf4j
@Service
public class WeightBoneService {


    /**
     * 初始化称骨页面用户数据
     * @return
     */
    public UserReq initUserReq() {
        UserReq userReq = new UserReq(){{
            setGender(1);
            setUserName("");
            setYears(WeightBoneInitUtil.initYears());
            setMonths(WeightBoneInitUtil.initMonths());
            setDays(WeightBoneInitUtil.initDays());
            setHours(WeightBoneInitUtil.initHours());
            setMinutes(WeightBoneInitUtil.initMinutes());
            setBYear("1980");
            setBMonth("1");
            setBDay("1");
            setBHour("0");
            setBMinute("0");
        }};
        return userReq;
    }


    /**
     * 算法
     * @param userReq
     * @return
     */
    public BoneInfo weightBone(UserReq userReq) {
        BoneInfo boneInfo = new BoneInfo();
        try {
            String info = WeightBoneUtil.generateInfo(userReq);
            //出生年
            String year = userReq.getBYear();
            //公历生日yyyyMMdd
            String solarBirthDay = getSolarDate(userReq);
            //转换为阴历生日yyyyMMdd
            String lunarBirthDay = CalendarUtil.solarToLunar(solarBirthDay);
            //年份天干地支
            String td = CalendarUtil.lunarYear2TD(Integer.valueOf(year));
            //出生年骨重
            Double yearWeight = YearWeightEnum.yearWeightMap.get(td).getValue();

            //阴历出生月
            Integer month = CalendarUtil.getMonthBirthday(lunarBirthDay);
            //出生月骨重
            Double monthWeight = MonthWeightEnum.monthWeightEnumMap.get(month).getValue();

            //阴历出生日
            Integer day = CalendarUtil.getDayBirthday(lunarBirthDay);
            //出生日骨重
            Double dayWeight = DayWeightEnum.dayWeightEnumMap.get(day).getValue();

            //出生小时
            String hour = userReq.getBHour();
            //出生时辰
            String shichen = ShiChenUtil.convert2SC(hour);
            //出生时骨重
            Double hourWeight = HourWeightEnum.hourWeightEnumMap.get(shichen).getValue();


            boneInfo.setBoneWeight(yearWeight + monthWeight + dayWeight + hourWeight);

//            boneInfo.setBoneInfo();

        } catch (Exception e) {
            log.error("==>weightBone error:" + e);
        }
        return boneInfo;
    }

    private String getSolarDate(UserReq userReq) {
        return userReq.getBYear()
                + (userReq.getBMonth().length() > 1 ? userReq.getBMonth() : "0" + userReq.getBMonth())
                + (userReq.getBDay().length() > 1 ? userReq.getBDay() : "0" + userReq.getBDay());
    }

    public static void main(String[] args) {
        UserReq userReq=new UserReq(){{
            setBYear("1993");
            setBMonth("7");
            setBDay("22");
            setBHour("6");
            setBMinute("30");
        }};
        WeightBoneService service = new WeightBoneService();
        BoneInfo info = service.weightBone(userReq);
        log.info("您的骨重是：" + info.getBoneWeight());
    }

}
