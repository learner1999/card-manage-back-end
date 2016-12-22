package com.zheteng123.jersey.pojo;

import java.util.Date;

/**
 * Created on 2016/12/22.
 */
public class ExchangeTicket {

    private int applyForGiftId;
    private String exchangeCode;
    private Date time;
    private String storeName;
    private String giftName;
    private double giftMoney;

    public int getApplyForGiftId() {
        return applyForGiftId;
    }

    public void setApplyForGiftId(int applyForGiftId) {
        this.applyForGiftId = applyForGiftId;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(double giftMoney) {
        this.giftMoney = giftMoney;
    }
}
