package com.elaine.androidutils.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;

/**
 * 跳转qq聊天界面
 * 使用方法:对方QQ需要开通陌生人聊天等设置
 * 例如:QQServiceUtil.toQQService(this, "聊天对象的qq号码");
 *
 * @author elaine
 */
public class QQServiceUtil {

    /**
     * 是否安装了QQ客户端
     */
    private static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        if (pInfo != null) {
            for (int i = 0; i < pInfo.size(); i++) {
                String pn = pInfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 跳转到聊天页面
     */
    public static void toQQService(Context context, String qq) {
        if (isQQClientAvailable(context)) {
            final String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq + "&version=1";
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
        } else {
            Toast.makeText(context, "本机未安装QQ应用", Toast.LENGTH_SHORT).show();
        }
    }
}
