package com.debughao.column.utils;

import android.widget.Toast;

import com.debughao.column.App;

/**
 * Created by Administrator on 2016/5/16.
 */
public class MyToast {

    private MyToast() {
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     * @param message
     */
    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     * @param message
     */
    public static void showShort(int message) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     * @param message
     */
    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     * @param message
     */
    public static void showLong(int message) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     * @param message
     * @param duration
     */
    public static void show(int message, int duration) {
        if (isShow)
            Toast.makeText(App.getInstance(), message, duration).show();
    }


}
