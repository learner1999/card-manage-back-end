package com.zheteng123.jersey.pojo;

/**
 * Created on 2016/11/20.
 * 商家优惠信息及备注
 */
public class Preferential {
    private int id;  // 自增主键
    private int storeId;  // 商家id
    private String cardLogo;  // 卡logo地址
    private String discountString;  // 折扣字段
    private String minusString;  // 满减字段
    private String giftString;  // 满送字段
    private String noteString;  // 备注字段
    private double exchangeScore;  // 一块钱对应的积分数

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

    public String getCardLogo() {
        return cardLogo;
    }

    public void setCardLogo(String cardLogo) {
        this.cardLogo = cardLogo;
    }

    public String getDiscountString() {
        return discountString;
    }

    public void setDiscountString(String discountString) {
        this.discountString = discountString;
    }

    public String getMinusString() {
        return minusString;
    }

    public void setMinusString(String minusString) {
        this.minusString = minusString;
    }

    public String getGiftString() {
        return giftString;
    }

    public void setGiftString(String giftString) {
        this.giftString = giftString;
    }

    public String getNoteString() {
        return noteString;
    }

    public void setNoteString(String noteString) {
        this.noteString = noteString;
    }

    public double getExchangeScore() {
        return exchangeScore;
    }

    public void setExchangeScore(double exchangeScore) {
        this.exchangeScore = exchangeScore;
    }
}
