package com.dm.dontknow.ui;

import android.os.Bundle;

import cn.droidlover.xdroid.base.XActivity;

/**
 * Created by m on 2016/12/27.
 */

public abstract class BaseActivity extends XActivity {


    @Override
    public abstract void initView();

    @Override
    public abstract void initData(Bundle savedInstanceState);

    @Override
    public abstract void setListener();

    @Override
    public abstract int getLayoutId();
}
