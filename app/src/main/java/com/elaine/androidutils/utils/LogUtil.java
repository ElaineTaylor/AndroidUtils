package com.elaine.androidutils.utils;

import android.util.Log;

import com.elaine.androidutils.BuildConfig;

/**
 * 日志打印
 * 使用方法:在需要的地方进行调用
 * 例如:LogUtil.i("debug+++", "打印内容");
 * 说明:在debug状态下打印日志，release状态下不打印日志
 *
 * @author elaine
 */
public class LogUtil {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;
    private static final int LEVEL = BuildConfig.DEBUG ? VERBOSE : NOTHING;

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg);
        }
    }
}
