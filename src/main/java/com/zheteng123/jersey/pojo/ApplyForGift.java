package com.zheteng123.jersey.pojo;

import java.util.Date;

public class ApplyForGift {
    private Integer id;

    /**
    * 礼品id
    */
    private Integer giftId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 申请状态
    */
    private Integer status;

    /**
    * 时间戳
    */
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}