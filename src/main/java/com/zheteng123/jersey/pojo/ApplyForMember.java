package com.zheteng123.jersey.pojo;

import com.zheteng123.jersey.adapter.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

public class ApplyForMember {
    /**
    * 自增字段
    */
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
    * 申请状态（0表示申请未处理，1表示申请通过，2表示申请失败）
    */
    private Integer status;

    /**
    * 申请时间
    */
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date time;

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