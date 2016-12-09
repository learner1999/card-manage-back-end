package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.ApplyForMemberMapper;
import com.zheteng123.jersey.pojo.ApplyForMember;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/12/5.
 */
public class ApplyForMemberService {

    /**
     * 添加一条申请记录
     * @param applyForMember 申请记录
     * @return 是否成功
     */
    public boolean insert(ApplyForMember applyForMember) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);
        int counter = mapper.insert(applyForMember);
        sqlSession.close();

        return counter == 1;
    }

    /**
     * 查询所有申请记录
     * @return 申请记录列表
     */
    public List<ApplyForMember> findAll() {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);
        ApplyForMember applyForMember = new ApplyForMember();
        List<ApplyForMember> applyForMemberList = mapper.select(applyForMember);
        sqlSession.close();

        return applyForMemberList;
    }

    /**
     * 查询指定商家会员申请记录
     * @param applyForMember 申请信息（只用到其中的 storeId）
     * @return 申请记录列表
     */
    public List<ApplyForMember> findByStoreId(ApplyForMember applyForMember) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);

        ApplyForMember applyForMemberTemp = new ApplyForMember();
        applyForMemberTemp.setStoreId(applyForMember.getStoreId());

        List<ApplyForMember> applyForMemberList = mapper.select(applyForMemberTemp);
        sqlSession.close();

        return applyForMemberList;
    }

    /**
     * 查询指定用户会员申请记录
     * @param applyForMember 申请信息（只用到其中的 storeId 和 userId）
     * @return 申请记录
     */
    public ApplyForMember findByUserIdAndStoreId(ApplyForMember applyForMember) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);

        ApplyForMember applyForMemberTemp = new ApplyForMember();
        applyForMemberTemp.setUserId(applyForMember.getUserId());
        applyForMemberTemp.setStoreId(applyForMember.getStoreId());

        List<ApplyForMember> applyForMemberList = mapper.select(applyForMemberTemp);
        sqlSession.close();

        return applyForMemberList.isEmpty() ? null : applyForMemberList.get(0);
    }

    /**
     * 删除指定用户会员申请记录
     * @param applyForMember 申请信息（只用到其中的 storeId 和 userId）
     * @return 是否成功删除
     */
    public boolean deleteByUserIdAndStoreId(ApplyForMember applyForMember) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);

        ApplyForMember applyForMemberTemp = new ApplyForMember();
        System.out.println("service:" + applyForMember.getUserId());
        applyForMemberTemp.setUserId(applyForMember.getUserId());
        applyForMemberTemp.setStoreId(applyForMember.getStoreId());

        int counter = mapper.delete(applyForMemberTemp);
        sqlSession.close();

        return counter == 1;
    }
}
