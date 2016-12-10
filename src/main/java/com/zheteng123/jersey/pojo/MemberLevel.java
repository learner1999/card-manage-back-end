package com.zheteng123.jersey.pojo;

/**
 * Created on 2016/12/9.
 */
public class MemberLevel {

    private int id;  // 表自增字段
    private int storeId;  // 商家id
    private int point;  // 达到等级所需积分
    private int level;  // 对应的等级（0为银卡，1为金卡，2为钻石卡）
    private double discount;  // 等级对应折扣

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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
