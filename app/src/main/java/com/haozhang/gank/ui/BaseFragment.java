package com.haozhang.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * @author HaoZhang
 * @date 2016/6/20.
 */
public class BaseFragment extends Fragment {

    public static final String STATE_HIDE = "FRAGMENT_STATE_HIDE";

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 保存fragment的hide状态
        // 注意！！！
        /**
         * 在fragment的创建Activity中，需要经过saveInstanceState判断再创建fragment
        public class MainActivity ... {
            @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
            // 这里一定要在save为null时才加载Fragment，Fragment中onCreateView等生命周里加载根子Fragment同理
            // 因为在页面重启时，Fragment会被保存恢复，而此时再加载Fragment会重复加载，导致重叠
            if(saveInstanceState == null){
                // 这里加载根Fragment

                }
            }
        }
         */
        if (null != savedInstanceState) {
            boolean b = savedInstanceState.getBoolean(STATE_HIDE);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (b){
                ft.hide(this);
            }else {
                ft.show(this);
            }
            ft.commit();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_HIDE, isHidden());
    }
}
