package com.neu.neuer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neu.neuer.R;
import com.neu.neuer.entity.Icon;

import java.util.List;

/**
 * Created by fengyuluo on 2017/11/17.
 */

public class HomeAdapter extends RecyclerView.Adapter {
   //定义viewType
    public static final int itemHeader = 0;
    public static final int itemIcon = 1;
    public static final int itemTimetable = 2;
    public static final int itemNews = 3;

    private List<Icon> iconList;
    private View headerView;

     //初始化图标数据
    public void setIconList(List<Icon> iconList){
        this.iconList = iconList;
    }
    public void setHeaderView(View headerView){
        this.headerView = headerView;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return itemHeader;
        }else{
            return itemIcon;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(headerView != null &&viewType == itemHeader){
            return new mViewHolder(headerView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item_layout,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==itemHeader)
            return;
        final int pos = getRealPosition(holder);

    }
    private int getRealPosition(RecyclerView.ViewHolder holder){
        int position = holder.getLayoutPosition();
        return headerView == null ? position : position-1;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class mViewHolder extends RecyclerView.ViewHolder{
        public mViewHolder(View itemView) {
            super(itemView);
        }
    }
}
