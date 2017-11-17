package com.neu.neuer.view;

/**
 * Created by fengyuluo on 2017/11/13.
 */

public interface IMainView {
    /**
     * 轮播图片获得
     */
    void setPicture(String[] purls);
    /**
     * 课表刷新
     */
    void setTimetable(String timetable);

    /**
     * 校园头条
     */
    void setSchoolNews(String news);
}
