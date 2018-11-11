package com.tery.edu.litewechat.service.user;

import com.alibaba.fastjson.JSONObject;
import com.tery.edu.litewechat.domain.weightBone.BoneInfo;
import com.tery.edu.litewechat.domain.weightBone.UserReq;
import com.tery.edu.litewechat.enums.bone.DayWeightEnum;
import com.tery.edu.litewechat.enums.bone.HourWeightEnum;
import com.tery.edu.litewechat.enums.bone.MonthWeightEnum;
import com.tery.edu.litewechat.enums.bone.YearWeightEnum;
import com.tery.edu.litewechat.util.calendar.CalendarUtil;
import com.tery.edu.litewechat.util.calendar.ShiChenUtil;
import com.tery.edu.litewechat.util.calendar.ZodiacUtil;
import com.tery.edu.litewechat.util.weightBone.WeightBoneInitUtil;
import com.tery.edu.litewechat.util.weightBone.BoneInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by wanglei on 2018/10/18 上午9:51
 **/
@Slf4j
@Service
public class WeightBoneService {


    /**
     * 初始化称骨页面用户数据
     *
     * @return
     */
    public UserReq initUserReq() {
        UserReq userReq = new UserReq() {{
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
     *
     * @param userReq
     * @return
     */
    public BoneInfo weightBone(UserReq userReq) {
        BoneInfo boneInfo = new BoneInfo();
        try {
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

            Double boneWeight = yearWeight + monthWeight + dayWeight + hourWeight;
            BigDecimal bg = new BigDecimal(boneWeight);
            double doubleValue = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            //骨重量
            boneInfo.setBoneWeightValue(doubleValue);
            //骨重（市斤）
            String boneWeightStr = WeightBoneInitUtil.boneWeight(doubleValue);
            boneInfo.setBoneWeight(boneWeightStr);
            //骨重代表信息
            boneInfo.setBoneWeightInfo(BoneInfoUtil.boneWeightInfoMap.get(boneWeightStr));
            //姓名
            boneInfo.setName(userReq.getUserName());
            //性别
            boneInfo.setSex(userReq.getGender() == 1 ? "男" : "女");
            boneInfo.setAge(String.valueOf(CalendarUtil.age(solarBirthDay)));
            //属相
            boneInfo.setShuXiang(ZodiacUtil.getZodiac(Integer.valueOf(year)));
            //公历生日
            boneInfo.setGlBirthday(solarBirthDay);
            //年份天干地支
            boneInfo.setYearTD(td);
            boneInfo.setMonthBZ(String.valueOf(month));
            boneInfo.setDayBZ(day <= 9 ? "初" + String.valueOf(day) : String.valueOf(day));
            boneInfo.setHourBZ(shichen);

            boneInfo.setYlYear(year);
            boneInfo.setYlMonth(String.valueOf(month));
            boneInfo.setYlDay(String.valueOf(day));
            boneInfo.setYlHour(boneInfo.getHourBZ());

            boneInfo.setBoneInfo(userReq.getUserName()
                    + " " + boneInfo.getSex()
                    + " " + userReq.getBYear()
                    + "年" + userReq.getBMonth()
                    + "月" + userReq.getBDay()
                    + "日" + userReq.getBHour()
                    + "时" + userReq.getBMinute()
                    + "分" + boneInfo.getAge()
                    + "岁, 属" + boneInfo.getShuXiang());
            boneInfo.setBoneInfoBZ(boneInfo.getYlYear()
                    + " " + boneInfo.getYlMonth()
                    + "月 " + boneInfo.getYlDay()
                    + "日 " + boneInfo.getYlHour());

            boneInfo.setBoneInfoSep("您的骨重构成&nbsp;年："
                    + yearWeight + "，&nbsp;月："
                    + monthWeight + "，&nbsp;日："
                    + dayWeight + "，&nbsp;时辰："
                    + hourWeight);
            log.info("==>weightBone infos:" + boneInfo.toString());
            return boneInfo;

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

//    public static void main(String[] args) {
//        UserReq userReq=new UserReq(){{
//            setBYear("1988");
//            setBMonth("10");
//            setBDay("15");
//            setBHour("0");
//            setBMinute("30");
//        }};
//        WeightBoneService service = new WeightBoneService();
//        BoneInfo info = service.weightBone(userReq);
//        log.info("您的骨重是：" + info.toString());
//    }

}
