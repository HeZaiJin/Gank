package com.haozhang.gank.ui.adapter;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haozhang.gank.R;
import com.haozhang.gank.utils.LogUtils;
import com.haozhang.gank.utils.ScreenUtils;
import com.haozhang.rest.modle.WelfareItemDatas;

/**
 * @author HaoZhang
 * @date 2016/6/28.
 */
public class MainAdapter extends BaseQuickAdapter<WelfareItemDatas> {
    private static final String TAG = "MainAdapter";
    private Activity mContext;
    private int mWidth,mHeight;
    public MainAdapter(Activity context) {
        super(R.layout.fragment_main_item, null);
        mWidth = ScreenUtils.getScreenWidth(context);
        mHeight = ScreenUtils.getDp(R.dimen.main_item_height,context);
        LogUtils.d(TAG,"width :"+mWidth+", height"+mHeight);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, WelfareItemDatas welfareItemDatas) {
        Glide.with(mContext).load(welfareItemDatas.getUrl()).dontAnimate().centerCrop().into((ImageView) baseViewHolder.getView(R.id.img));
    }
}
