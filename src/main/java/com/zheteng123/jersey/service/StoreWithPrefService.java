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

    /**
     * 查询所有商家信息（包含优惠信息）
     * @return 商家信息列表
     */
    public List<StoreWithPref> getStoreWithPrefAll() {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectAllLazyLoading();
        sqlSession.close();
        return storeWithPrefs;
    }

    /**
     * 根据类别查询商家信息（包含优惠信息）
     * @param category 类别
     * @return 商家信息列表
     */
    public List<StoreWithPref> getStoreWithPrefByCategory(String category) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectByCategoryLazyLoading(category);
        sqlSession.close();
        return storeWithPrefs;
    }
}
