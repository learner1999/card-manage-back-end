package com.zheteng123.jersey.pojo;

public class Member {
    private Integer id;

    /**
    * 商家id
    */
    private Integer storeId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 用户卡号
    */
    private String cardNum;

    /**
    * 用户积分数
    */
    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}