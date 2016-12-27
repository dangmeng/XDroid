package com.dm.dontknow;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dm.dontknow.ui.BaseActivity;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;


public class MainActivity extends BaseActivity {

    private PagerBottomTabLayout tabLayout;
    private Controller controller;
    private FrameLayout mainContainer;

    @Override
    public void initView() {
        tabLayout = (PagerBottomTabLayout) findViewById(R.id.main_tab);
        mainContainer = (FrameLayout) findViewById(R.id.main_container);
        TextView tv1 = new TextView(context);
        tv1.setText("首页");
        mainContainer.removeAllViews();
        mainContainer.addView(tv1);
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
        /*TabItemBuilder tabItemBuilder2 = new TabItemBuilder(context).create()
                .setText("位置")
                .setDefaultIcon(R.mipmap.ic_launcher)
                .setSelectedColor(tabColors[1])
                .setTag("B")
                .build();
        TabItemBuilder tabItemBuilder3 = new TabItemBuilder(context).create()
                .setText("搜索")
                .setDefaultIcon(R.mipmap.ic_launcher)
                .setSelectedColor(tabColors[2])
                .setTag("C")
                .build();
        TabItemBuilder tabItemBuilder4 = new TabItemBuilder(context).create()
                .setText("帮助")
                .setDefaultIcon(R.mipmap.ic_launcher)
                .setSelectedColor(tabColors[3])
                .setTag("D")
                .build();*/
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
                switch (index) {
                    case 0:
                        TextView tv1 = new TextView(context);
                        tv1.setText("首页");
                        mainContainer.removeAllViews();
                        mainContainer.addView(tv1);
                        break;
                    case 1:
                        TextView tv2 = new TextView(context);
                        tv2.setText("位置");
                        mainContainer.removeAllViews();
                        mainContainer.addView(tv2);
                        break;
                    case 2:
                        TextView tv3 = new TextView(context);
                        tv3.setText("搜索");
                        mainContainer.removeAllViews();
                        mainContainer.addView(tv3);
                        break;
                    case 3:
                        TextView tv4 = new TextView(context);
                        tv4.setText("帮助");
                        mainContainer.removeAllViews();
                        mainContainer.addView(tv4);
                        break;
                }
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
}
