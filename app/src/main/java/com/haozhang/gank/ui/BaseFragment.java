package com.haozhang.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 懒加载
 *
 * @author HaoZhang
 * @date 2016/6/20.
 */
public abstract class BaseFragment extends SwipeBackFragment {

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndEvents(view);
    }

    /**
     * content view 的layout id
     * @return
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化view
     * @param view
     */
    protected abstract void initViewsAndEvents(View view);


    @Override
    public void onDestroy() {
        DetoryViewAndThing();
        super.onDestroy();
    }


    /**
     * 加载数据 / 开启动画 / 广播.....
     */
    protected abstract void onFirstUserVisible();

    /**
     * 用户可见的时候
     * 开启动画 / 广播.....
     */
    protected abstract void onUserVisible();

    private void onFirstUserInvisible() { }

    /**
     * 用户不可见的时候
     * 注销广播，暂停动画
     */
    protected abstract void onUserInvisible();

    /**
     * 回收销毁
     */
    protected abstract void DetoryViewAndThing();
}
