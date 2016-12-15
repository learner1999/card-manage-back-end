package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.pojo.GiftExample;
import com.zheteng123.jersey.pojo.OrderForGift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiftMapper {
    int countByExample(GiftExample example);

    int deleteByExample(GiftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    int insertSelective(Gift record);

    List<Gift> selectByExample(GiftExample example);

    List<Gift> selectBy(OrderForGift orderForGift);

    Gift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gift record, @Param("example") GiftExample example);

    int updateByExample(@Param("record") Gift record, @Param("example") GiftExample example);

    int updateByPrimaryKeySelective(Gift record);

    int updateByPrimaryKey(Gift record);
}