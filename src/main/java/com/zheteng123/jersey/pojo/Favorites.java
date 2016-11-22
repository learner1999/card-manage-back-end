package com.zheteng123.jersey.pojo;

import java.sql.Timestamp;

/**
 * Created on 2016/11/20.
 */
public class Favorites {
    private int id;  // 自增主键
    private int storeId;  // 商家id
    private int userId;  // 用户id
    private Timestamp time;  // 时间戳

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
}
