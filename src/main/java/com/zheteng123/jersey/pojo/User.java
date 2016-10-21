package com.zheteng123.jersey.pojo;

import java.util.Date;

/**
 * Created on 2016/10/9.
 */
public class User {
    private int user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
