package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.StoreWithPrefMapper;
import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/11/22.
 */
public class StoreWithPrefService {

    public List<StoreWithPref> getStoreWithPrefAll() {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectAllLazyLoading();
        sqlSession.close();
        return storeWithPrefs;
    }
}
