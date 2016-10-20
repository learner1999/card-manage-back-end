package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.StoreMapper;
import com.zheteng123.jersey.pojo.Store;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created on 2016/10/18.
 */
public class StoreRegService {

    public Store register(Store store) {

        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        // 验证手机号是否已经被注册过
        String telephone = store.getOwner_telephone();
        if (storeMapper.findStoreByOwnerTelephone(telephone) != null) {
            return null;
        }

        // 添加用户
        int result = storeMapper.addStore(store);
        sqlSession.commit();
        if (result == 0) {
            return null;
        }

        return store;
    }
}
