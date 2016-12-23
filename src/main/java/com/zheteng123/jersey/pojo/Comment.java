package com.zheteng123.jersey.pojo;

import com.zheteng123.jersey.adapter.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;

/**
 * Created on 2016/11/20.
 */
public class Comment {
    private int id;  // 自增主键
    private int storeId;  // 商家id
    private int userId;  // 用户id

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Timestamp time;  // 评论时间
    private double stars;  // 用户评星
    private double point;  // 当前订单积分数
    private String comment;  // 评价内容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
