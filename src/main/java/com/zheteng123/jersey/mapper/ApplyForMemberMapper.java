package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.ApplyForMember;
import com.zheteng123.jersey.pojo.ApplyForMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyForMemberMapper {
    int countByExample(ApplyForMemberExample example);

    int deleteByExample(ApplyForMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyForMember record);

    int insertSelective(ApplyForMember record);

    List<ApplyForMember> selectByExample(ApplyForMemberExample example);

    ApplyForMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyForMember record, @Param("example") ApplyForMemberExample example);

    int updateByExample(@Param("record") ApplyForMember record, @Param("example") ApplyForMemberExample example);

    int updateByPrimaryKeySelective(ApplyForMember record);

    int updateByPrimaryKey(ApplyForMember record);
}