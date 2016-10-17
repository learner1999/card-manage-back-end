package com.zheteng123.jersey.pojo;

/**
 * Created on 2016/10/12.
 */
public class LoginInfo {
    private String username;  // 用户昵称或者手机号
    private String password;

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
}
