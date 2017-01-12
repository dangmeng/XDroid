package com.dm.dontknow.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dm.dontknow.R;

import cn.droidlover.xdroid.base.XFragment;
import cn.droidlover.xdroid.log.XLog;

/**
 * Created by m on 2017/1/12.
 * ${describe} 搜索
 */

public class SearchFragment extends XFragment {

    @Override
    public void initView() {

    }

    @Override
    public void initView(View rootView) {
        TextView tvDes = (TextView) rootView.findViewById(R.id.tv_des_page);
        tvDes.setText(SearchFragment.class.getSimpleName());
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        XLog.d("SearchFragment--->","SearchFragment be created");
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_common_layout;
    }
}
