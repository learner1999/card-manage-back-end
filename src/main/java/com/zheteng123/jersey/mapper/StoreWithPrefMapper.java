package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.StoreSort;
import com.zheteng123.jersey.pojo.StoreWithPref;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2016/11/22.
 */
public interface StoreWithPrefMapper {


    List<StoreWithPref> selectAllLazyLoading();

    List<StoreWithPref> selectByCategoryLazyLoading(String category);

    List<StoreWithPref> selectByNameLazyLoading(String name);

    StoreWithPref selectByPrimaryKeyLazyLoading(int id);

     int selectStoreCategoryCount(String category);

    int selectStoreCount();

     int selectStoreSortCount(@Param("storeSorts") List<StoreSort> storeSort);

    List<StoreWithPref> selectStoreCategoryByPagenow(StoreSort storeSort);

    List<StoreWithPref> selectStoreSortByPagenow(int pagenow,@Param("storeSorts") List<StoreSort> storeSort);
}
