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
    public int insert(Member record){
        return memberMapper.insert(record);
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


}
