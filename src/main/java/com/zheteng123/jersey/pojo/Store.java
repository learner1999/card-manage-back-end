package com.zheteng123.jersey.pojo;

/**
 * Created on 2016/10/17.
 */
public class Store {
    private int id;  // 自增id
    private String owner_name;  // 店铺所有者姓名
    private String owner_telephone; // 店铺所有者和手机号
    private String owner_password;  // 登录密码
    private String name;  // 店铺名
    private String phone;  // 电话
    private String description;  // 描述
    private String category;  // 所属分类
    private String address_province;  // 所在省
    private String address_city;  // 所在市
    private String address_district;  // 所在区
    private String address_street;  // 所在街道
    private String address;  // 详细地址
    private double coord_long;  // 经度
    private double coord_lat;  // 纬度
    private int service_type;  // 服务类型（1-虚拟卡，2-实体卡）

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress_province() {
        return address_province;
    }

    public void setAddress_province(String address_province) {
        this.address_province = address_province;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_district() {
        return address_district;
    }

    public void setAddress_district(String address_district) {
        this.address_district = address_district;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getService_type() {
        return service_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_telephone() {
        return owner_telephone;
    }

    public void setOwner_telephone(String owner_telephone) {
        this.owner_telephone = owner_telephone;
    }

    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCoord_long() {
        return coord_long;
    }

    public void setCoord_long(double coord_long) {
        this.coord_long = coord_long;
    }

    public double getCoord_lat() {
        return coord_lat;
    }

    public void setCoord_lat(double coord_lat) {
        this.coord_lat = coord_lat;
    }
}
