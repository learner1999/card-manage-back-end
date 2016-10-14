package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.UserMapper;
import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created on 2016/10/12.
 */
public class LoginService {

    public User login(LoginInfo info) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.findUserByLoginInfo(info);
    }
}
