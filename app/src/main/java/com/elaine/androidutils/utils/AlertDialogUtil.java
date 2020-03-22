package com.elaine.androidutils.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * AlertDialog修正工具
 *
 * @author elaine
 * 使用方法如下：
 * new AlertDialogUtil.Builder(this).showAlertDialog("问题", true, true).setOnAlertDialogListener(new AlertDialogUtil.OnAlertDialogListener() {
 * @Override public void onPositive() {
 * ToastUtil.shortShow(MainActivity.this,"取消");
 * }
 * @Override public void onNegative() {
 * ToastUtil.shortShow(MainActivity.this,"确定");
 * }
 * });
 */
public class AlertDialogUtil {

    public static class Builder {
        private Activity activity;
        private OnAlertDialogListener onAlertDialogListener;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setOnAlertDialogListener(OnAlertDialogListener onAlertDialogListener) {
            this.onAlertDialogListener = onAlertDialogListener;
            return this;
        }

        public Builder showAlertDialog(String msg, boolean isShowPositive, boolean isShowNegative) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(msg);
            if (isShowPositive) {
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        onAlertDialogListener.onPositive();
                    }
                });
            }
            if (isShowNegative) {
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        onAlertDialogListener.onNegative();
                    }
                });
            }
            AlertDialog dialog = builder.create();
            dialog.show();
            Window dialogWindow = dialog.getWindow();
            WindowManager m = activity.getWindowManager();
            Display d = m.getDefaultDisplay();
            WindowManager.LayoutParams p = dialogWindow.getAttributes();
            p.width = (int) (d.getWidth() * 0.95);
            p.gravity = Gravity.CENTER;
            dialogWindow.setAttributes(p);
            return this;
        }

    }

    public interface OnAlertDialogListener {
        void onPositive();

        void onNegative();
    }
}
