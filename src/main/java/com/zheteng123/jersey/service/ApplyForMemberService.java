package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.ApplyForMemberMapper;
import com.zheteng123.jersey.pojo.ApplyForMember;
import com.zheteng123.jersey.pojo.ApplyForMemberExample;
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
        List<ApplyForMember> applyForMemberList = mapper.selectByExample(new ApplyForMemberExample());
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

        ApplyForMemberExample example = new ApplyForMemberExample();
        example.or()
                .andStoreIdEqualTo(applyForMember.getUserId());

        List<ApplyForMember> applyForMemberList = mapper.selectByExample(example);
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

        ApplyForMemberExample example = new ApplyForMemberExample();
        example.or()
                .andStoreIdEqualTo(applyForMember.getStoreId())
                .andUserIdEqualTo(applyForMember.getUserId());
        List<ApplyForMember> applyForMemberList = mapper.selectByExample(example);
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

        ApplyForMemberExample example = new ApplyForMemberExample();
        example.or()
                .andStoreIdEqualTo(applyForMember.getStoreId())
                .andUserIdEqualTo(applyForMember.getUserId());
        int counter = mapper.deleteByExample(example);
        sqlSession.close();

        return counter == 1;
    }

    /**
     * 根据id修改用户会员申请
     * @param applyForMember 会员申请信息
     * @param id 自增id
     * @return 是否成功
     */
    public boolean updateByPrimaryKey(ApplyForMember applyForMember, int id) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);

        applyForMember.setId(id);
        int counter = mapper.updateByPrimaryKey(applyForMember);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 根据id查询申请信息
     * @param id 自增id
     * @return 申请信息
     */
    public ApplyForMember selectByPrimaryKey(int id) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        ApplyForMemberMapper mapper = sqlSession.getMapper(ApplyForMemberMapper.class);

        ApplyForMember applyForMember = mapper.selectByPrimaryKey(id);

        sqlSession.close();
        return applyForMember;
    }
}
