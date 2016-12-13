package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.ApplyForGift;
import com.zheteng123.jersey.pojo.ApplyForGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyForGiftMapper {
    int countByExample(ApplyForGiftExample example);

    int deleteByExample(ApplyForGiftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyForGift record);

    int insertSelective(ApplyForGift record);

    List<ApplyForGift> selectByExample(ApplyForGiftExample example);

    ApplyForGift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyForGift record, @Param("example") ApplyForGiftExample example);

    int updateByExample(@Param("record") ApplyForGift record, @Param("example") ApplyForGiftExample example);

    int updateByPrimaryKeySelective(ApplyForGift record);

    int updateByPrimaryKey(ApplyForGift record);
}