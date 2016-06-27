package com.haozhang.gank.ui.adapter;

import android.content.Context;
import android.webkit.WebView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haozhang.gank.R;
import com.haozhang.rest.modle.SearchItemDatas;

/**
 * @author HaoZhang
 * @date 2016/6/24.
 */
public class SearchListAdapter extends BaseQuickAdapter<SearchItemDatas> {
    private Context mContext;

    public SearchListAdapter(Context context){
        super(R.layout.fragment_search_item, null);
        mContext = context;
    }
    @Override
    protected void convert(BaseViewHolder holder, SearchItemDatas item) {
        WebView webView = holder.getView(R.id.web);
//        webView.loadData(item.getReadability(),WebView.SCHEME_GEO,"utf-8");
//        Glide.with(mContext).load(item.getUrl())
    }
}
