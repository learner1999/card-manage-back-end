package com.zheteng123.jersey.service;

import com.zheteng123.jersey.pojo.Favorites;
import com.zheteng123.jersey.mapper.FavoritesMapper;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

public class FavoritesService {

    private SqlSession mSqlSession;

    @Resource
    private FavoritesMapper favoritesMapper;

    public FavoritesService() {
        mSqlSession = DbUtils.getSqlSession(true);
        favoritesMapper = mSqlSession.getMapper(FavoritesMapper.class);
    }

    public int insert(Favorites pojo){
        return favoritesMapper.insert(pojo);
    }

    public int insertByUserId(int userId, Favorites pojo){
        pojo.setUserId(userId);
        return favoritesMapper.insert(pojo);
    }

    public int insertList(List< Favorites> pojos){
        return favoritesMapper.insertList(pojos);
    }

    public List<Favorites> select(Favorites pojo){
        return favoritesMapper.select(pojo);
    }

    public List<Favorites> selectAllByUserId(int userId){
        Favorites pojo = new Favorites();
        pojo.setUserId(userId);
        return favoritesMapper.select(pojo);
    }

    public int update(Favorites pojo){
        return favoritesMapper.update(pojo);
    }

    public int delete(Favorites pojo) {
        return favoritesMapper.delete(pojo);
    }

    public int deleteById(int id) {
        Favorites pojo = new Favorites();
        pojo.setId(id);
        return delete(pojo);
    }

    public int deleteByUserIdAndStoreId(int userId, int storeId) {
        Favorites pojo = new Favorites();
        pojo.setId(0);
        pojo.setUserId(userId);
        pojo.setStoreId(storeId);
        return delete(pojo);
    }

    /**
     * 查询收藏是否存在
     * @param pojo
     * @return
     */
    public boolean isExist(Favorites pojo) {
        return select(pojo).size() != 0;
    }

    /**
     * 查询指定用户和商家的收藏记录是否存在
     * @param userId
     * @param pojo
     * @return
     */
    public boolean isExist(int userId, Favorites pojo) {
        pojo.setId(0);
        pojo.setUserId(userId);
        return isExist(pojo);
    }
}
