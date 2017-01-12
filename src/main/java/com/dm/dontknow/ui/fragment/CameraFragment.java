package com.dm.dontknow.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.dm.dontknow.R;
import com.dm.dontknow.adapter.CameraAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.droidlover.xdroid.base.XFragment;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by m on 2017/1/12.
 * ${describe} 相机
 */

public class CameraFragment extends XFragment{

    private XRecyclerContentLayout contentLayout;
    private CameraAdapter adapter;

    @Override
    public void initView() {}

    @Override
    public void initView(View rootView) {
        contentLayout = (XRecyclerContentLayout) rootView.findViewById(R.id.recycle_latout);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initAdapter();
    }

    private void initAdapter() {
        final List<String> datas = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            datas.add(i + 1 + "");
        }
        final XRecyclerView recyclerView = contentLayout.getRecyclerView();
        recyclerView.verticalLayoutManager(getActivity());
        recyclerView.setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                adapter.addData(datas);
            }

            @Override
            public void onLoadMore(int page) {

            }
        });

        adapter = new CameraAdapter(getActivity());
        adapter.setData(datas);
        recyclerView.setAdapter(adapter);
        recyclerView.useDefLoadMoreView();
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.camera_fragment_layout;
    }
}
