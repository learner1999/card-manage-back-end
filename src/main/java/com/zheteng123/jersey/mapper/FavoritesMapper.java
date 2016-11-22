package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.Favorites;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesMapper {

    int insert(@Param("pojo") Favorites pojo);

    int insertList(@Param("pojos") List< Favorites> pojo);

    List<Favorites> select(@Param("pojo") Favorites pojo);

    int update(@Param("pojo") Favorites pojo);

    int delete(@Param("pojo") Favorites pojo);

}
