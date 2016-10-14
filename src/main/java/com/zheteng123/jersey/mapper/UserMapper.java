package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.User;

import java.util.List;

/**
 * Created on 2016/10/9.
 */
public interface UserMapper {
    public User findUserById(int id);

    public List<User> findUserByUsername(String username);

    public User findUserByLoginInfo(LoginInfo loginInfo);
}
