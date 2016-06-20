package com.haozhang.gank.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nid on 2015/2/9.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler instance = new CrashHandler();
    private String path = "log/default.log";
    Thread.UncaughtExceptionHandler mDefault;

    public static CrashHandler getInstance() {
        return instance;
    }

    public void init(String path) {
        this.path = path;
        mDefault = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            File f = new File(Environment.getExternalStorageDirectory(), this.path);
            File folder = f.getParentFile();
            if (!folder.exists()) {
                folder.mkdirs();
            }
            PrintWriter pw = new PrintWriter(f);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            pw.write(df.format(new Date()));
            pw.write("\n");
            ex.printStackTrace(pw);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mDefault.uncaughtException(thread, ex);
    }

}
