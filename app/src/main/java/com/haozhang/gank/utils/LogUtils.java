package com.haozhang.gank.utils;

import android.util.Log;

import com.haozhang.gank.BuildConfig;

/**
 * Created by szy on 2015/4/30.
 */
public class LogUtils {
    public static void d(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg);
        }
    }
}
