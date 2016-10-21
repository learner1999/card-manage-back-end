package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.UserMapper;
import com.zheteng123.jersey.pojo.User;
import com.zheteng123.jersey.pojo.UserRegInfo;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created on 2016/10/20.
 */
public class RegisterService {

    public boolean register(UserRegInfo userRegInfo) {

        // 核实短信验证码
        if (!verifySmsCode(userRegInfo.getSmsCode())) {
            return false;
        }

        // 判断手机号是否已经被注册
        SqlSession sqlSession = DbUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userTel = userMapper.findUserByTelephone(userRegInfo.getTelephone());
        if (userTel != null) {
            return false;
        }


        // 添加用户
        User user = new User(userRegInfo);
        int counter = userMapper.addUser(user);
        sqlSession.commit();
        return counter != 0;
    }

    private boolean verifySmsCode(String smsCode) {

        return true;
    }
}
