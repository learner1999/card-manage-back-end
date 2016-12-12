package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.MemberMapper;
import com.zheteng123.jersey.pojo.Member;
import com.zheteng123.jersey.pojo.MemberExample;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by feige_com on 2016/11/24.
 */
public class MemberService {
    private SqlSession mSqlSession;

    @Resource
    private MemberMapper memberMapper;

    public MemberService(){
         mSqlSession = DbUtils.getSqlSession(true);
        memberMapper = mSqlSession.getMapper(MemberMapper.class);
    }

    /**
     * 插入新的会员记录
     * @param record
     * @return
     */
    public boolean insert(Member record){
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        int counter = mapper.insert(record);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 选字段插入
     * @param record
     * @return
     */
     public int insertSelective(Member record){
         record.setId(0);
        return memberMapper.insertSelective(record);
    }

    /**
     * 修改会员信息
     * @param record
     * @return
     */
    public  int updateByPrimaryKey(Member record){
        return  memberMapper.updateByPrimaryKey(record);
    }

    /**
     * 修改会员信息
     * @param id
     * @param reccod
     * @return
     */
    public int updateByPrimaryKeySelective(Integer id,Member reccod){
        reccod.setId(id);
        return  memberMapper.updateByPrimaryKeySelective(reccod);
    }

    /**
     * 修改会员信息（还没有control联系）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example){
        return memberMapper.updateByExampleSelective(record,example);
    }

    /**
     * 修改会员信息
     * @param record
     * @param example
     * @return
     */
    public  int updateByExample(@Param("record") Member record, @Param("example") MemberExample example){
        return memberMapper.updateByExample(record, example);
    }

    /**
     * 删除会员信息
     * @param id
     * @return
     */
   public  int deleteByPrimaryKey(Integer id){

       return  memberMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除所有会员信息
     * @param example
     * @return
     */
    public int deleteByExample(MemberExample example){
        return  memberMapper.deleteByExample(example);
    }


    /**
     *查询会员信息
     * @param id
     * @return
     */
    public  Member selectByPrimaryKey(Integer id){

        return  memberMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询会员信息
     * @param example
     * @return
     */
    public List<Member> selectByExample(MemberExample example){
        return memberMapper.selectByExample(example);
    }

    /**
     * 查询会员信息
     * @param example
     * @return
     */
   public int countByExample(MemberExample example){
       return  memberMapper.countByExample(example);
   }


    /**
     * 根据商家id查询会员列表
     * @param storeId 商家id
     * @return 会员信息列表
     */
    public List<Member> selectByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        MemberExample example = new MemberExample();
        example.or().andStoreIdEqualTo(storeId);
        List<Member> members = mapper.selectByExample(example);

        sqlSession.close();
        return members;
    }

    /**
     * 根据商家id和用户id查询会员信息
     * @param storeId 商家id
     * @param userId 用户id
     * @return 会员信息
     */
    public Member selectByStoreIdAndUserId(int storeId, int userId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        MemberExample example = new MemberExample();
        example.or().andStoreIdEqualTo(storeId).andUserIdEqualTo(userId);
        List<Member> members = mapper.selectByExample(example);

        sqlSession.close();

        if (members.size() > 0) {
            return members.get(0);
        }

        return null;
    }
}
