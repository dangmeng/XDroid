package com.dm.dontknow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dm.dontknow.R;

import cn.droidlover.xdroid.base.SimpleRecAdapter;

/**
 * Created by m on 2017/1/12.
 * ${describe}
 */

public class CameraAdapter extends SimpleRecAdapter<String,CameraAdapter.ViewHolder> {


    public CameraAdapter(Context context) {
        super(context);
    }

    @Override
    public CameraAdapter.ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_layout;
    }

    @Override
    public void onBindViewHolder(CameraAdapter.ViewHolder holder, int position) {
        String dataStr = data.get(position);
        holder.tvItem.setText(dataStr);
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItem =   (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
