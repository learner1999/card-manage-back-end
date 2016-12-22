package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.MemberLevelMapper;
import com.zheteng123.jersey.pojo.MemberLevel;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;


public class MemberLevelService {

    @Resource
    private MemberLevelMapper memberLevelMapper;

    public int insert(MemberLevel pojo){
        return memberLevelMapper.insert(pojo);
    }

    public int insertList(List< MemberLevel> pojos){
        return memberLevelMapper.insertList(pojos);
    }

    public List<MemberLevel> select(MemberLevel pojo){
        return memberLevelMapper.select(pojo);
    }

    public int update(MemberLevel pojo){
        return memberLevelMapper.update(pojo);
    }

    /**
     * 查询商家会员等级情况
     * @param storeId 商家id
     * @return 会员等级列表
     */
    public List<MemberLevel> findMemberLevelByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberLevelMapper mapper = sqlSession.getMapper(MemberLevelMapper.class);

        MemberLevel memberLevel = new MemberLevel();
        memberLevel.setStoreId(storeId);
        List<MemberLevel> memberLevelList = mapper.select(memberLevel);

        sqlSession.close();
        return memberLevelList;
    }

    /**
     * 新增会员级别
     * @param memberLevel 会员级别信息
     * @return 是否成功
     */
    public boolean addMemberLevel(MemberLevel memberLevel) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        MemberLevelMapper mapper = sqlSession.getMapper(MemberLevelMapper.class);

        int counter = mapper.insert(memberLevel);

        sqlSession.close();
        return counter == 1;

    }

    /**
     * 更新会员级别信息
     * @param memberLevel 会员级别信息
     * @return 是否成功
     */
    public boolean updateMemberLevel(MemberLevel memberLevel) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        MemberLevelMapper mapper = sqlSession.getMapper(MemberLevelMapper.class);

        int counter = mapper.update(memberLevel);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 根据id查询会员等级记录
     * @param id 自增id
     * @return 会员等级记录
     */
    public MemberLevel findById(int id) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberLevelMapper mapper = sqlSession.getMapper(MemberLevelMapper.class);

        MemberLevel memberLevel = new MemberLevel();
        memberLevel.setId(id);
        List<MemberLevel> memberLevels = mapper.select(memberLevel);
        if (memberLevels.size() > 0) {
            return memberLevels.get(0);
        } else {
            return null;
        }
    }

}
