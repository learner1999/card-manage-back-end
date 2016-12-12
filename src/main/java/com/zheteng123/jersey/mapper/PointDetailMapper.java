package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.PointDetail;
import com.zheteng123.jersey.pojo.PointDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointDetailMapper {
    int countByExample(PointDetailExample example);

    int deleteByExample(PointDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointDetail record);

    int insertSelective(PointDetail record);

    List<PointDetail> selectByExample(PointDetailExample example);

    PointDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointDetail record, @Param("example") PointDetailExample example);

    int updateByExample(@Param("record") PointDetail record, @Param("example") PointDetailExample example);

    int updateByPrimaryKeySelective(PointDetail record);

    int updateByPrimaryKey(PointDetail record);
}