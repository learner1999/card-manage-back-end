package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.User;

import java.util.List;

/**
 * Created on 2016/10/9.
 */
public interface UserMapper {
    User findUserById(int id);

    List<User> findUserByUsername(String username);

    User findUserByLoginInfo(LoginInfo loginInfo);

    int addUser(User user);

    User findUserByTelephone(String telephone);
}
