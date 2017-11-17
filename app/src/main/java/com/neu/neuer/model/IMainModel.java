package com.neu.neuer.model;

/**
 * Created by fengyuluo on 2017/11/13.
 */

public interface IMainModel {
    /**
     * 回调函数
     * 用于Model返回数据给presenter
     */
    interface MainListener{

        /**
         * 返回轮播图片
         */
        void updatePicture(String[] urls);

        /**
         * 返回课表
         */
        void updateTimetable(String timetable);

        /**
         * 返回校内新闻
         */
        void updateNews(String news);

        /**
         *网络错误应有提示，但是次数应该有所限制
         */
        void onError();
    }

    /**
     * 获得图片
     */
    void getPictures(final MainListener mainListener);
    /**
     * 获得课表
     */
    void getTimeTable(final MainListener mainListener);
    /**
     * 获得校园头条
     */
    void getNews(final MainListener mainListener);
}
