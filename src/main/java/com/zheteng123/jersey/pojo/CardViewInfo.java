package com.zheteng123.jersey.pojo;

/**
 * Created on 2016/12/14.
 */
public class CardViewInfo {

    private int memberId;  // 会员id
    private int storeId;  // 商家id
    private String pic;  // logo 图片路径
    private String barcode;// 条形码
    private String title;  // 卡片名称
    private double sale;  // 折扣
    private int level;  // 卡片等级
    private boolean isVirtual;  // 是否为虚拟卡

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean virtual) {
        isVirtual = virtual;
    }
}
