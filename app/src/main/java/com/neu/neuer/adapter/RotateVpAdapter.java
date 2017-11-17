package com.neu.neuer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.neu.neuer.R;
import com.neu.neuer.entity.RotateBean;

import java.util.List;

/**
 * Created by fengyuluo on 2017/11/15.
 */

public class RotateVpAdapter extends PagerAdapter {
    private List<RotateBean> datas;
    private Context context;
    private LayoutInflater inflater;
    public RotateVpAdapter(List<RotateBean> datas,Context context){
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public RotateVpAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public void setDatas(List<RotateBean> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        // 为了让ViewPager到最后一页不会像翻书一样回到第一页
        // 设置页数为int最大值,这样向下滑动永远都是下一页
        return datas ==null?0:Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_vp,container,false);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.item_iv);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        container.addView(convertView);
        return convertView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
