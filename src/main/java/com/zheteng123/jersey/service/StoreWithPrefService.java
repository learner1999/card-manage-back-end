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
    private int PageSize=10;//希望一页有多少条数据
    private int PageCount=0;//总共有多少页

    public List<StoreWithPref> getStoreWithPrefAll() {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectAllLazyLoading();
        sqlSession.close();
        return storeWithPrefs;
    }
    public int getStoreCount(){
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        int Count=mapper.selectStoreCount();
        if(Count%PageSize==0){
            PageCount=Count/PageSize;
        }else{
            PageCount=(Count/PageSize)+1;
        }
        sqlSession.close();
        return PageCount;
    }

    public List<StoreWithPref> getStoreByPageNow(Integer pageNow) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        pageNow=(pageNow-1)* PageSize;
        List<StoreWithPref> storeWithPrefs = mapper.selectStoreByPageNow(pageNow);
        sqlSession.close();
        return storeWithPrefs;
    }
}
