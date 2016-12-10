package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.MemberLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberLevelMapper {

    int insert(@Param("pojo") MemberLevel pojo);

    int insertList(@Param("pojos") List< MemberLevel> pojo);

    List<MemberLevel> select(@Param("pojo") MemberLevel pojo);

    int update(@Param("pojo") MemberLevel pojo);

}
