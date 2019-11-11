package com.elaine.androidutils.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences工具
 * 使用方法:
 * 在标记公共类中定义public static final String IS_REMIND = "isRemind";
 * 写入数据(boolean类型):SharedPreferencesUtil.writeData(SetupActivity.this, IS_REMIND, false);
 * 读取数据:boolean isRemind = (boolean) SharedPreferencesUtil.getData(this, IS_REMIND, false);
 *
 * @author elaine
 */
public class SharedPreferencesUtil {

    private static final String FILE_NAME = "sp";

    /*记录数据*/
    public static void writeData(Context context, String key, Object value) {
        String dataType = value.getClass().getSimpleName();
        SharedPreferences.Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        if ("Integer".equals(dataType)) {
            editor.putInt(key, (Integer) value);
        } else if ("String".equals(dataType)) {
            editor.putString(key, (String) value);
        } else if ("Boolean".equals(dataType)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("Float".equals(dataType)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(dataType)) {
            editor.putLong(key, (Long) value);
        }
        editor.apply();
    }

    /*获取数据*/
    public static Object getData(Context context, String key, Object value) {
        Object object = null;
        String dataType = value.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if ("Integer".equals(dataType)) {
            object = sp.getInt(key, (Integer) value);
        } else if ("String".equals(dataType)) {
            object = sp.getString(key, (String) value);
        } else if ("Boolean".equals(dataType)) {
            object = sp.getBoolean(key, (Boolean) value);
        } else if ("Float".equals(dataType)) {
            object = sp.getFloat(key, (Float) value);
        } else if ("Long".equals(dataType)) {
            object = sp.getLong(key, (Long) value);
        }
        return object;
    }
}
