package com.haozhang.gank;

import android.app.Application;

import com.haozhang.gank.utils.CrashHandler;

/**
 * @author HaoZhang
 * @date 2016/6/17.
 */
public class GankApp extends Application {


    private static GankApp sInstance;

    public static GankApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        // init crash handler
        CrashHandler.getInstance().init("log/gank.log");
    }



}
