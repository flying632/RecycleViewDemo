package com.neu.neuer.entity;

import java.io.Serializable;

/**
 * Created by wubihang on 16/9/12.
 */

/**
 * 轮播图的实例
 */
public class RotateBean implements Serializable {

    private int imgId;
    private String imgUrl;

    public RotateBean() {
    }

    public RotateBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public RotateBean(int imgId) {
        this.imgId = imgId;
    }

    public RotateBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
