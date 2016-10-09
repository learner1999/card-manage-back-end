package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.UserMapper;
import com.zheteng123.jersey.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created on 2016/10/9.
 */
public class UserService {

    private SqlSessionFactory sqlSessionFactory;

    public UserService() {
        String resource = "SqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public List<User> getUserByUsername(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.findUserByUsername(name);
    }
}
