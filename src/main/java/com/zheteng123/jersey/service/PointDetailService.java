package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.PointDetailMapper;
import com.zheteng123.jersey.pojo.PointDetail;
import com.zheteng123.jersey.pojo.PointDetailExample;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/12/12.
 */
public class PointDetailService {

    /**
     * 根据用户id查询积分明细
     * @param userId 用户id
     * @return 积分明细
     */
    public List<PointDetail> findByUserId(int userId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        PointDetailMapper mapper = sqlSession.getMapper(PointDetailMapper.class);

        PointDetailExample example = new PointDetailExample();
        example.or().andUserIdEqualTo(userId);
        List<PointDetail> pointDetails = mapper.selectByExample(example);
        sqlSession.close();

        return pointDetails;
    }

    /**
     * 根据商家id查询积分明细
     * @param storeId 商家id
     * @return 积分明细
     */
    public List<PointDetail> findByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        PointDetailMapper mapper = sqlSession.getMapper(PointDetailMapper.class);

        PointDetailExample example = new PointDetailExample();
        example.or().andStoreIdEqualTo(storeId);
        List<PointDetail> pointDetails = mapper.selectByExample(example);
        sqlSession.close();

        return pointDetails;
    }


    /**
     * 新增积分记录（消费记录）
     * @param pointDetail 积分明细
     * @return 是否成功
     */
    public boolean insert(PointDetail pointDetail) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        PointDetailMapper mapper = sqlSession.getMapper(PointDetailMapper.class);

        int counter = mapper.insert(pointDetail);
        sqlSession.close();

        return counter == 1;
    }

    /**
     * 根据用户id和商家id查询积分明细
     * @param userId 用户id
     * @param storeId 商家id
     * @return 积分明细
     */
    public List<PointDetail> findByUserIdAndStoreId(int userId, int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        PointDetailMapper mapper = sqlSession.getMapper(PointDetailMapper.class);

        PointDetailExample example = new PointDetailExample();
        example.or().andUserIdEqualTo(userId).andStoreIdEqualTo(storeId);
        List<PointDetail> pointDetails = mapper.selectByExample(example);
        sqlSession.close();

        return pointDetails;
    }
}
