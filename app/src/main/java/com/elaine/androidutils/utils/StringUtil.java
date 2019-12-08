package com.elaine.androidutils.utils;

/**
 * 字符串工具
 *
 * @author elaine
 * @date 2019/10/29
 */
public class StringUtil {
    /**
     * 手机号中间四位处理成*
     *
     * @param phone 手机号
     * @return  字符串，eg.137****2308
     */
    public static String phoneHandle(String phone) {
        if (phone.length() == 11) {
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        } else {
            return phone;
        }
    }
}
