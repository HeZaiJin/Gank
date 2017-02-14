package com.haozhang.gank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haozhang.gank.R;
import com.haozhang.gank.ui.BaseFragment;
import com.haozhang.gank.ui.adapter.MainAdapter;
import com.haozhang.gank.utils.RecycleViewDivider;
import com.haozhang.rest.RESTClient;
import com.haozhang.rest.modle.BaseData;
import com.haozhang.rest.modle.WelfareItemDatas;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 福利
 *
 * @author HaoZhang
 * @date 2016/6/27.
 */
public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragmentLog";

    private MainAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private int mPage = 1;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_main_layout;
    }

    @Override
    public void initView(View parent) {
        mRecyclerView = (RecyclerView) parent.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        getAdapter().openLoadMore(10,true);
        getAdapter().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPage++;
                RESTClient.loadWelfareDatas(mPage).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<BaseData<WelfareItemDatas>>() {
                            @Override
                            public void call(BaseData<WelfareItemDatas> welfareItemDatasBaseData) {
                                if (null == welfareItemDatasBaseData) return;
                                getAdapter().notifyDataChangedAfterLoadMore(welfareItemDatasBaseData.getResults(),true);
                            }
                        });
            }
        });
        getAdapter().setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
            }
        });
        mRecyclerView.addItemDecoration(new RecycleViewDivider(_mActivity,LinearLayoutManager.HORIZONTAL,15, getResources().getColor(R.color.primary_light)));
        mRecyclerView.setAdapter(getAdapter());

        mRefreshLayout = (SwipeRefreshLayout) parent.findViewById(R.id.refresh);
        mRefreshLayout.setColorSchemeColors(R.color.primary);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
       super.onResume();
    }

    public MainAdapter getAdapter() {
        if (null == mAdapter) {
            mAdapter = new MainAdapter(_mActivity);
        }
        return mAdapter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"initLazyView");
        if (null == savedInstanceState) {
            mRefreshLayout.setProgressViewOffset(false,0,30);
            mRefreshLayout.setRefreshing(true);
            refresh();
        }
    }

    public void refresh() {
        mPage = 1;
        Log.d(TAG,"refresh start ");
        RESTClient.loadWelfareDatas(mPage).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseData<WelfareItemDatas>>() {
                    @Override
                    public void call(BaseData<WelfareItemDatas> welfareItemDatasBaseData) {
                        Log.d(TAG, "call() called with: " + "welfareItemDatasBaseData = [" + welfareItemDatasBaseData + "]");
                        if (null == welfareItemDatasBaseData) return;
                        getAdapter().setNewData(welfareItemDatasBaseData.getResults());
                        mRefreshLayout.setRefreshing(false);
                        Log.d(TAG,"refresh down");
                    }
                });
    }

}
