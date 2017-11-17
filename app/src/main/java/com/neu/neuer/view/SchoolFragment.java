package com.neu.neuer.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fengyuluo on 2017/11/13.
 */

public class SchoolFragment extends Fragment {
    public static SchoolFragment newInstance(String paraml){
        SchoolFragment mf = new SchoolFragment();
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
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
