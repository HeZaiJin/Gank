package com.haozhang.gank.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author HaoZhang
 * @date 2016/6/28.
 */
public class ScreenUtils {
    private static final String TAG = "ScreenUtils";

    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        LogUtils.d(TAG,"screen width : "+width);
        return width;
    }

    /**
     * dpתpx
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px( float dpValue,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int getDp(int res,Context context){
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(res);
    }

    /**
     * pxתdp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip( float pxValue,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }



}
