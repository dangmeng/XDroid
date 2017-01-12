package com.dm.dontknow;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.dm.dontknow.ui.BaseActivity;
import com.dm.dontknow.ui.fragment.CameraFragment;
import com.dm.dontknow.ui.fragment.HelpFragment;
import com.dm.dontknow.ui.fragment.PositionFragment;
import com.dm.dontknow.ui.fragment.SearchFragment;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;


public class MainActivity extends BaseActivity {

    private PagerBottomTabLayout tabLayout;
    private Controller controller;

    private FragmentManager supportFragmentManager;

    @Override
    public void initView() {
        tabLayout = (PagerBottomTabLayout) findViewById(R.id.main_tab);
        //获取管理器
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        //初次进入显示相机
        transaction.replace(R.id.main_container,new CameraFragment());
        transaction.commit();

    }



    @Override
    public void initData(Bundle savedInstanceState) {
        int[] tabColors = {0xFF00796B, 0xFF5B4947, 0xFF607D8B, 0xFFF57C00, 0xFFF57C00};
        TabItemBuilder tabItemBuilder1 = new TabItemBuilder(context).create()
                .setText("相机")
                .setDefaultIcon(R.mipmap.ic_launcher)
                .setSelectedColor(tabColors[0])
                .setTag("A")
                .build();
        controller = tabLayout.builder()
                .addTabItem(tabItemBuilder1)
                .addTabItem(R.mipmap.ic_launcher, "位置", tabColors[1])
                .addTabItem(R.mipmap.ic_launcher, "搜索", tabColors[2])
                .addTabItem(R.mipmap.ic_launcher, "帮助", tabColors[3])
                .setMode(TabLayoutMode.HIDE_TEXT | TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build();
    }

    @Override
    public void setListener() {
        OnTabItemSelectListener listener = new OnTabItemSelectListener() {
            @Override
            public void onSelected(int index, Object tag) {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (index) {
                    case 0:
                        transaction.replace(R.id.main_container,new CameraFragment());
                        break;
                    case 1:
                        transaction.replace(R.id.main_container,new PositionFragment());
                        break;
                    case 2:
                        transaction.replace(R.id.main_container,new SearchFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.main_container,new HelpFragment());
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onRepeatClick(int index, Object tag) {}
        };
        controller.addTabItemClickListener(listener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    public void initView(View rootView) {}
}
