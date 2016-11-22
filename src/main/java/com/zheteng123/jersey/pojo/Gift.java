package com.zheteng123.jersey.pojo;

public class Gift {
    private Integer id;

    /**
    * 商店id
    */
    private Integer storeId;

    /**
    * 礼品id
    */
    private Integer giftId;

    /**
    * 兑换需要的积分
    */
    private Double point;

    /**
    * 需另付多少钱
    */
    private Double money;

    /**
    * 库存
    */
    private Integer stock;

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

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}