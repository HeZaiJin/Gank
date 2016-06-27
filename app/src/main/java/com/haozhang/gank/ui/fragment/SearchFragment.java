package com.haozhang.gank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.haozhang.gank.R;
import com.haozhang.gank.ui.BaseFragment;
import com.haozhang.gank.ui.adapter.SearchListAdapter;
import com.haozhang.rest.RESTClient;
import com.haozhang.rest.modle.SearchDatas;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author HaoZhang
 * @date 2016/6/24.
 */
public class SearchFragment extends BaseFragment {
    private static final String TAG = "SearchFragment";
    RecyclerView mRecyclerView;
    SearchListAdapter mAdapter;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "懒加载  加载数据");
        RESTClient.loadSearchDatas("Android", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchDatas>() {
                    @Override
                    public void call(SearchDatas searchDatas) {
                        if (null == searchDatas) return;
                        Log.d("search", "get datas  :" + searchDatas.getResults().size());
                        getAdapter().setNewData(searchDatas.getResults());
                    }
                })
        ;
    }

    public SearchListAdapter getAdapter(){
        if (null == mAdapter){
            mAdapter = new SearchListAdapter(_mActivity);
        }
        return mAdapter;
    }

    @Override
    public void initView(View parent) {
        mRecyclerView = (RecyclerView) parent.findViewById(R.id.search_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setAdapter(getAdapter());
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_search_layout;
    }
}
