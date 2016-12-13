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

    /**
     * 根据id修改指定商家信息
     * @param store 商家信息
     * @param id 自增id
     * @return 是否成功
     */
    public boolean updateByPrimaryKey(Store store, int id) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        StoreMapper mapper = sqlSession.getMapper(StoreMapper.class);

        store.setId(id);
        int counter = mapper.updateByPrimaryKey(store);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 根据id查询商家信息
     * @param id 自增id
     * @return 商家信息
     */
    public Store findByPrimaryKey(int id) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreMapper mapper = sqlSession.getMapper(StoreMapper.class);

        Store store = mapper.findByPrimaryKey(id);

        sqlSession.close();
        return store;
    }
}
