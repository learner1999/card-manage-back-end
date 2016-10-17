package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.StoreMapper;
import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created on 2016/10/17.
 */
public class StoreLoginService {

    public Store login(LoginInfo info) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
        return storeMapper.findStoreByLoginInfo(info);
    }
}
