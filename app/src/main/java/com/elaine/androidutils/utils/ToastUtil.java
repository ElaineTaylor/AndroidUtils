package com.elaine.androidutils.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具
 * 使用方法:在需要的地方进行调用
 * 例如:ToastUtil.shortShow(this, "请输入手机号");
 *
 * @author elaine
 */

public class ToastUtil {
    private static Toast toast = null;
    private static Boolean isShow = true;

    private ToastUtil() {
        throw new UnsupportedOperationException("u can't instantiate");
    }

    @SuppressLint("ShowToast")
    public static void shortShow(Context context, String msg) {
        if (isShow) {
            if (toast == null) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    @SuppressLint("ShowToast")
    public static void longShow(Context context, String msg) {
        if (isShow) {
            if (toast == null) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    public void setCancel() {
        if (isShow && toast != null) {
            toast.cancel();
        }
    }

    public static void setIsShow(boolean isShowToast) {
        isShow = isShowToast;
    }
}
