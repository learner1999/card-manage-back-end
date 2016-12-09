package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.ApplyForMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyForMemberMapper {

    int insert(@Param("pojo") ApplyForMember pojo);

    int insertList(@Param("pojos") List< ApplyForMember> pojo);

    List<ApplyForMember> select(@Param("pojo") ApplyForMember pojo);

    int update(@Param("pojo") ApplyForMember pojo);

    int delete(@Param("pojo") ApplyForMember applyForMemberTemp);
}
