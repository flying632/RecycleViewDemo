package com.neu.neuer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by fengyuluo on 2017/11/16.
 */

/**
 * 为解决与ScrollView而重写
 */
public class IListView extends ListView {
    public IListView(Context context){
        super(context);
    }
    public IListView(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    public IListView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
