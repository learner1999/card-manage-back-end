package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.UserMapper;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


/**
 * Created on 2016/10/9.
 */
public class UserService {

    public List<User> getUserByUsername(String name) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByUsername(name);
        sqlSession.close();
        return userList;
    }

    public User getUserByTelephone(String telephone) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user =  userMapper.findUserByTelephone(telephone);
        sqlSession.close();

        return user;
    }
}
