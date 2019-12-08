package com.elaine.androidutils.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * activity管理工具
 * 使用方法:
 * 在activity的onCreate()方法中调用ActivityStackUtil.getInstance().addActivity(this);
 * 在activity的onDestroy()方法中调用ActivityStackUtil.getInstance().popActivity(this, true);
 *
 * @author elaine
 */
public class ActivityStackUtil {

    private static ActivityStackUtil instance;

    public ActivityStackUtil() {

    }

    public static ActivityStackUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityStackUtil.class) {
                instance = new ActivityStackUtil();
            }
        }
        return instance;
    }

    private static Stack<Activity> mStack;

    /**
     * 返回栈
     */
    public Stack<Activity> getActivitiesList() {
        return mStack;
    }

    /**
     * activity出栈
     */
    public void popActivity(Activity activity, boolean isFinish) {
        if (activity != null) {
            if (isFinish) {
                activity.finish();
            }
            mStack.remove(activity);
        }
    }

    /**
     * 获取栈的最新activity
     */
    public Activity currentActivity() {
        if (!mStack.isEmpty()) {
            return (Activity) mStack.lastElement();
        } else {
            return null;
        }
    }

    /**
     * 获取指定深度的下一个activity
     */
    public Activity getNextActivity(int dept) {
        if (dept <= mStack.size()) {
            return mStack.get(dept);
        } else {
            return null;
        }
    }

    /**
     * 向栈中添加a ctivity
     */
    public void addActivity(Activity activity) {
        if (mStack == null) {
            mStack = new Stack<Activity>();
        }
        mStack.add(activity);
    }

    /**
     * 删除栈中的所有activity
     */
    public void removeAllActivity() {
        while (mStack != null && mStack.size() > 0) {
            Activity activity = currentActivity();
            if (activity != null) {
                popActivity(activity, true);
            }
        }
    }

}
