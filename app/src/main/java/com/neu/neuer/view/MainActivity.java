package com.neu.neuer.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.neu.neuer.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {


    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
    private BottomNavigationBar bottomNavigationBar;
    private MainFragment mainFragment;
    private SchoolFragment schoolFragment;
    private MineFragment mineFragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("主页");
        setSupportActionBar(toolbar);

        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.tab_home,"主页"))
                .addItem(new BottomNavigationItem(R.drawable.tab_campus,"校园"))
                .addItem(new BottomNavigationItem(R.drawable.tab_me,"我"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);

        setDefaultFragment();
    }

    /**
     * 设置默认的首页
     */
    private void setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mainFragment = MainFragment.newInstance("主页");

        transaction.replace(R.id.tb,mainFragment);
        transaction.commit();

    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position){
            case 0:
                if(mainFragment == null){
                    mainFragment = MainFragment.newInstance("主页");
                }
                toolbar.setTitle("主页");
                transaction.replace(R.id.tb,mainFragment);
                break;
            case 1:
                if(schoolFragment == null){
                    schoolFragment = SchoolFragment.newInstance("学校");
                }
                toolbar.setTitle("校园");
                transaction.replace(R.id.tb,schoolFragment);
                break;
            case 2:
                if (mineFragment == null){
                    mineFragment = MineFragment.newInstance("我");
                }
                toolbar.setTitle("我");
                transaction.replace(R.id.tb,mineFragment);
                break;
            default:
                break;
        }
        //事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}