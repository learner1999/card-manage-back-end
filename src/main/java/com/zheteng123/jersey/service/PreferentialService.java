package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.PreferentialMapper;
import com.zheteng123.jersey.pojo.Preferential;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

public class PreferentialService {

    @Resource
    private PreferentialMapper preferentialDao;

    public PreferentialService() {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        preferentialDao = sqlSession.getMapper(PreferentialMapper.class);
    }

    public int insert(Preferential pojo){
        pojo.setId(0);
        return preferentialDao.insert(pojo);
    }

    public int insertList(List< Preferential> pojos){
        return preferentialDao.insertList(pojos);
    }

    public List<Preferential> select(Preferential pojo){
        return preferentialDao.select(pojo);
    }

    public int update(int id, Preferential pojo){
        pojo.setId(id);
        return preferentialDao.update(pojo);
    }

    public List<Preferential> selectAll() {
        return preferentialDao.selectAll();
    }

    public Preferential selectById(int id) {
        return preferentialDao.selectById(id);
    }
}
