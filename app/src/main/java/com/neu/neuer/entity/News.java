package com.neu.neuer.entity;

/**
 * Created by fengyuluo on 2017/11/16.
 */

/**
 * 新闻的实体类
 */
public class News {
    private String content;
    public News(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String Content){
        this.content = content;
    }
}
