package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.StoreMapper;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/10/20.
 */
public class StoreService {

    public List<Store> findStoreAll() {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        return storeMapper.findStoreAll();
    }

    public List<Store> findStoreByCategory(String category) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        return storeMapper.findStoreByCategory(category);
    }
}
