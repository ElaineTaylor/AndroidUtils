package com.elaine.androidutils.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO 待完善
 * 时间相关工具类
 *
 * @author elaine
 */
public class TimestampUtil {
    /**
     * 获取当前的时间
     *
     * @return long型-秒数
     */
    public static Long getNow() {
        return System.currentTimeMillis();
    }

    /**
     * 格式化时间 yyyy-MM-dd HH:mm:ss
     *
     * @param nowTime long型-当前时间
     * @return 字符串，eg.2019-12-08 14:27:00
     */
    public static String formatToYMDHMS(long nowTime) {
        Date d = new Date(nowTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    /**
     * 格式化时间 yyyy-MM-dd HH:mm
     *
     * @param nowTime long型-当前时间
     * @return 字符串，eg.2019-12-08 14:27
     */
    public static String formatToYMDHM(long nowTime) {
        Date d = new Date(nowTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(d);
    }

    /**
     * 格式化时间 yyyy-MM-dd
     *
     * @param nowTime long型-当前时间
     * @return 字符串，eg.2019-12-08
     */
    public static String formatToYMD(long nowTime) {
        Date d = new Date(nowTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    /**
     * 格式化时间 HH:mm:ss
     *
     * @param nowTime long型-当前时间
     * @return 字符串，eg.14:27:01
     */
    public static String formatToHMS(long nowTime) {
        Date d = new Date(nowTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }

    /**
     * 判断是否是同一天
     *
     * @param thisTime 对比时间
     * @param thatTime 对比时间
     * @return boolean
     */
    public static boolean isSameDate(long thisTime, long thatTime) {
        Calendar one = Calendar.getInstance();
        one.setTimeInMillis(thisTime);
        Calendar two = Calendar.getInstance();
        two.setTimeInMillis(thatTime);
        if (one.get(Calendar.YEAR) == two.get(Calendar.YEAR) && one.get(Calendar.MONTH) == two.get(Calendar.MONTH) && one.get(Calendar.DAY_OF_MONTH) == two.get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取前30天的所有日期
     *
     * @return String类型的数组，格式为：月/日
     */
    public static String[] getMonthDate() {
        String[] dateString = new String[30];
        for (int i = 0; i < 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -(29 - i));
            String date = (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE);
            dateString[i] = date;
        }
        return dateString;
    }

    /**
     * 获取年
     *
     * @param time long型的时间
     * @return int类型, 年
     */
    public static int getYearByLong(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月
     *
     * @param time long型的时间
     * @return int类型, 月
     */
    public static int getMonthByLong(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取现在的年
     *
     * @return int类型, 年
     */
    public static int getNowYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取现在的月
     *
     * @return int类型, 月
     */
    public static int getNowMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 倒计时格式化为00:00:00
     *
     * @param finishTime 倒计时剩余时间
     * @return 格式化为00:00:00
     */
    public static String formatFinishTime(long finishTime) {
        int totalTime = (int) (finishTime / 1000);
        int hour = 0, minute = 0, second = 0;
        if (3600 <= totalTime) {
            hour = totalTime / 3600;
            totalTime = totalTime - 3600 * hour;
        }
        if (60 <= totalTime) {
            minute = totalTime / 60;
            totalTime = totalTime - 60 * minute;
        }
        if (0 <= totalTime) {
            second = totalTime;
        }
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append("0").append(hour).append(":");
        } else {
            sb.append(hour).append(":");
        }
        if (minute < 10) {
            sb.append("0").append(minute).append(":");
        } else {
            sb.append(minute).append(":");
        }
        if (second < 10) {
            sb.append("0").append(second);
        } else {
            sb.append(second);
        }
        return sb.toString();
    }

}
