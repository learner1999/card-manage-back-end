package com.zheteng123.jersey.pojo;

import java.sql.Date;

/**
 * Created on 2016/12/9.
 */
public class CashierInfo {

    private int userId;  // 用户id
    private int memberId;  // 会员id
    private String username;  // 用户昵称
    private int point;  // 会员积分
    private int level;  // 会员等级
    private Date birthday;  // 会员生日
    private double discount;  // 折扣
    private double exchange;  // 一块钱对应的积分数

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getExchange() {
        return exchange;
    }

    public void setExchange(double exchange) {
        this.exchange = exchange;
    }
}
