package com.elaine.androidutils.utils;

import android.text.TextUtils;

/**
 * 手机号验证
 * 使用说明:检查是否为空，是否符合号段
 * 例如:PhoneUtil.isMobileNum("12345678901");
 *
 * @author elaine
 */
public class PhoneUtil {
    /**
     * 判断字符串是否符合手机号码格式
     * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
     * 电信号段: 133,149,153,170,173,177,180,181,189
     */
    public static boolean isMobileNum(String mobileNum) {
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        if (TextUtils.isEmpty(mobileNum)) {
            return false;
        } else {
            return mobileNum.matches(telRegex);
        }
    }
}
