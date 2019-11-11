package com.elaine.androidutils.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * 软键盘工具
 * 使用说明:在activity.finish()之前调用
 * 例如:KeyboardUtil.hideKeyboard(this);
 *
 * @author elaine
 */
public class KeyboardUtil {

    public static void hideKeyboard(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && context.getCurrentFocus() != null) {
            if (context.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}

