package com.zheteng123.jersey.pojo;

import java.util.Date;

/**
 * Created on 2016/10/9.
 */
public class User {
    private int id;
    private String username;
    private String telephone;  // 补上手机号
    private String password;
    private Date birthday;
    private String avatar;

    public User() {
    }

    public User(UserRegInfo userRegInfo) {
        username = userRegInfo.getUsername();
        telephone = userRegInfo.getTelephone();
        password = userRegInfo.getPassword();
        birthday = userRegInfo.getBirthday();
        avatar = userRegInfo.getAvatar();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
