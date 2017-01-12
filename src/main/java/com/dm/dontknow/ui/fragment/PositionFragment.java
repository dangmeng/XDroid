package com.dm.dontknow.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dm.dontknow.R;

import cn.droidlover.xdroid.base.XFragment;
import cn.droidlover.xdroid.log.XLog;

/**
 * Created by m on 2017/1/12.
 * ${describe} 位置
 */

public class PositionFragment extends XFragment {

    @Override
    public void initView() {

    }

    @Override
    public void initView(View rootView) {
        TextView tvDes = (TextView) rootView.findViewById(R.id.tv_des_page);
        tvDes.setText(PositionFragment.class.getSimpleName());
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        XLog.d("PositionFragment--->","PositionFragment be created");
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_common_layout;
    }
}
