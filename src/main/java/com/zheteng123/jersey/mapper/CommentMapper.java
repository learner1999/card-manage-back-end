package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CommentMapper {

    int insert(@Param("pojo") Comment pojo);

    int insertList(@Param("pojos") List<Comment> pojo);

    List<Comment> select(@Param("pojo") Comment pojo);

    int update(@Param("pojo") Comment pojo);

    List<Comment> selectByStoreId(int storeId);
}
