package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.Preferential;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PreferentialMapper {

    int insert(@Param("pojo") Preferential pojo);

    int insertList(@Param("pojos") List< Preferential> pojo);

    List<Preferential> select(@Param("pojo") Preferential pojo);

    List<Preferential> selectAll();

    Preferential selectById(int id);

    int update(@Param("pojo") Preferential pojo);

}
