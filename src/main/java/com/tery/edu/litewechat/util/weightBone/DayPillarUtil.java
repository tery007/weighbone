package com.tery.edu.litewechat.util.weightBone;

import com.tery.edu.litewechat.util.calendar.CalendarUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wanglei on 2018/11/13 上午11:24
 **/
@Slf4j
public class DayPillarUtil {


    /**
     * 输入日期【格式为：'yyyyMMdd'】
     * 输出日柱
     * @param date
     * @return
     * @throws Exception
     */
    public static String dayPillar(String date) throws Exception {
        int year = Integer.valueOf(date.substring(0, 4));
        int r = 5 * (year - 1900) + (year - 1900 + 3) / 4 + 9 + dayOfYear(date);
        int u = r % 60;
        return CalendarUtil.getTiangan((u % 10) == 0 ? 10 : (u % 10))
                + CalendarUtil.getDizhi((u % 12) == 0 ? 12 : u % 12);
    }

    public static int dayOfYear(String date) throws Exception{

        int month = Integer.valueOf(date.substring(4, 6));
        int days = 0;
        for (int i = 1; i < month; i++) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            calendar.setTime(sdf.parse(
                    date.substring(0, 4) + (i > 9 ? i : "0" + i)
                            + date.substring(6)));
            days += calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        days += Integer.valueOf(date.substring(6));
        return days;
    }
}
