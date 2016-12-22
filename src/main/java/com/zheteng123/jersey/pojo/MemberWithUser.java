package com.zheteng123.jersey.pojo;

public class MemberWithUser {
    private Integer id;

    /**
    * 商家id
    */
    private Integer storeId;

    /**
    * 用户信息
    */
    private User user;

    /**
    * 用户卡号
    */
    private String cardNum;

    /**
    * 用户积分数
    */
    private Integer point;

    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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