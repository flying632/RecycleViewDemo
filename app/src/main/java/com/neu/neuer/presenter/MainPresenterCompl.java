package com.neu.neuer.presenter;

import com.neu.neuer.model.IMainModel;
import com.neu.neuer.model.MainModel;
import com.neu.neuer.view.IMainView;

/**
 * Created by fengyuluo on 2017/11/13.
 */

public class MainPresenterCompl implements IMainPresenter ,IMainModel.MainListener {
    IMainView iMainView;
    IMainModel iMainModel;

    public MainPresenterCompl(IMainView iMainView){
        this.iMainView =iMainView;
        iMainModel = new MainModel();
    }

    @Override
    public void initView() {

    }

    @Override
    public void updatePicture(String[] urls) {

    }

    @Override
    public void updateTimetable(String timetable) {

    }

    @Override
    public void updateNews(String news) {

    }

    @Override
    public void onError() {

    }
}
