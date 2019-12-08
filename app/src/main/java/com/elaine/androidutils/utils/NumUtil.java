package com.elaine.androidutils.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author elaine
 */
public class NumUtil {
    /**
     * 保留两位小数
     *
     * @param num double
     * @return 字符串，eg.2.45
     */
    public static String getMumWithTwo(double num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }

    /**
     * 保留一位小数
     *
     * @param num double
     * @return 字符串，eg.2.4
     */
    public static String getMumWithOne(double num) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(num);
    }

    /**
     * 保留两位小数，直接去除后面几位
     *
     * @param money double
     * @return 字符串，eg.2.45
     */
    public static String getMoneyForWallet(double money) {
        BigDecimal b = new BigDecimal(money);
        return String.valueOf(b.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
    }

    /**
     * 格式化数值，三位一个逗号
     *
     * @param num int
     * @return 字符串，eg.123,455,556
     */
    public static String getMumWithComma(int num) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(num);
    }

    /**
     * 百分比格式化
     *
     * @param now 现在的进度
     * @param all 总进度
     * @return 字符串，eg.50%
     */
    public static String getPercent(int now, int all) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float) now / (float) all * 100);
        return result;
    }
}
