package com.elaine.androidutils.utils;

import android.os.Build;

/**
 * 设备信息工具
 * 使用方法:
 * 调用DeviceInfoUtil.getDeviceInfo()
 * 需要在AndroidManifest.xml中配置相关权限<uses-permission android:name="android.permission.READ_PHONE_STATE" />
 *
 * @author elaine
 */
public class DeviceInfoUtil {

    public static String getDeviceInfo() {
        return "|BOARD_" + Build.BOARD
                + "|BRAND_" + Build.BRAND
                + "|CPU_ABI_" + Build.CPU_ABI
                + "|CPU_ABI2_" + Build.CPU_ABI2
                + "|DEVICE_" + Build.DEVICE
                + "|DISPLAY_" + Build.DISPLAY
                + "|HOST_" + Build.HOST
                + "|ID_" + Build.ID
                + "|MANUFACTURER_" + Build.MANUFACTURER
                + "|MODEL_" + Build.MODEL
                + "|PRODUCT_" + Build.PRODUCT
                + "|TAGS_" + Build.TAGS
                + "|TYPE_" + Build.TYPE
                + "|USER_" + Build.USER
                + "|SERIAL_" + Build.SERIAL
                + "|VERSION_" + "," + Build.VERSION.CODENAME + ",V" + Build.VERSION.RELEASE + "," + Build.VERSION.INCREMENTAL;
    }
}
