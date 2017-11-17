package com.neu.neuer.view;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.neu.neuer.R;
import com.neu.neuer.adapter.HomeAdapter;
import com.neu.neuer.adapter.RotateVpAdapter;
import com.neu.neuer.base.CommonAdapter;
import com.neu.neuer.base.ViewHolder;
import com.neu.neuer.entity.Icon;
import com.neu.neuer.entity.News;
import com.neu.neuer.entity.RotateBean;
import com.neu.neuer.presenter.IMainPresenter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengyuluo on 2017/11/13.
 */

public class MainFragment extends Fragment implements IMainView,View.OnClickListener {

    private static final int TIME = 5000;

    private ViewPager viewPager;
    private LinearLayout pointLl;// 轮播状态改变的小圆点容器
    private RotateVpAdapter vpAdapter;
    private IMainPresenter iMainPresenter;

    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;

    //数据集
    private List<RotateBean> imgData;


    public static MainFragment newInstance(String paraml){
        MainFragment mf = new MainFragment();
        Bundle args = new Bundle();
        args.putString("schoolNum",paraml);
        mf.setArguments(args);
        return mf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.home_layout,container,false);
       Bundle bundle = getArguments();
       viewPager = (ViewPager)view.findViewById(R.id.rotate_vp);
       pointLl = (LinearLayout)view.findViewById(R.id.rotate_point_container);
       String schoolNum = bundle.getString("schoolNum");

       buildDatas();//构造数据

        //设置头
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_home_layout,null);
        HomeAdapter homeAdapter = new HomeAdapter();
        homeAdapter.setHeaderView(header);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.home_recycler);
        recyclerView.setAdapter(homeAdapter);


        vpAdapter = new RotateVpAdapter(imgData,getActivity());
        viewPager.setAdapter(vpAdapter);
        // ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
        // 为了保证第一页始终为数据的第0条 取余要为0,因此设置数据集合大小的倍数
        viewPager.setCurrentItem(imgData.size() * 100);

        //开始轮播
        handler = new Handler();
        startRotate();
        //添加轮播小点
        addPoints();
        //随轮播改变小点
        changePoint();

        return view;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setPicture(String[] purls) {

    }

    @Override
    public void setTimetable(String timetable) {

    }

    @Override
    public void setSchoolNews(String news) {

    }
    public void buildDatas(){
        //轮播图数据
        imgData = new ArrayList<>();
        imgData.add(new RotateBean(R.drawable.home1));
        imgData.add(new RotateBean(R.drawable.home2));
        imgData.add(new RotateBean(R.drawable.home3));

    }
    private void changePoint(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(isRotate){
                    //将所有小点设置为白色
                    for(int i=0;i<imgData.size();i++){
                        ImageView pointIv = (ImageView)pointLl.getChildAt(i);
                        pointIv.setImageResource(R.drawable.point_white);
                    }
                    //设置当前位置小点为灰色
                    ImageView iv = (ImageView)pointLl.getChildAt(position%imgData.size());
                    iv.setImageResource(R.drawable.point_grey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    /**
     * 添加轮播的小点
     */
    private void addPoints(){
        // 有多少张图加载多少个小点
        for(int i=0;i<imgData.size();i++){
            ImageView pointIv = new ImageView(getActivity());
            pointIv.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            pointIv.setLayoutParams(params);
            // 设置第0页小点的为灰色
            if(i==0){
                pointIv.setImageResource(R.drawable.point_grey);
            }else{
                pointIv.setImageResource(R.drawable.point_white);
            }
            pointLl.addView(pointIv);
        }
    }

    /**
     * 开始轮播
     */
    private void startRotate(){
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if(isRotate){
                    handler.postDelayed(rotateRunnable,TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable,TIME);
    }
    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }
}
