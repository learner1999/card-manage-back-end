package com.zheteng123.jersey.pojo;

import com.zheteng123.jersey.adapter.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

public class PointDetail {
    private Integer id;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 商家id
    */
    private Integer storeId;

    /**
    * 积分变动详情
    */
    private String detail;

    /**
    * 积分变动，增加为正，减少为负
    */
    private Double alteration;

    /**
    * 备注
    */
    private String note;

    /**
    * 时间戳
    */
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getAlteration() {
        return alteration;
    }

    public void setAlteration(Double alteration) {
        this.alteration = alteration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}