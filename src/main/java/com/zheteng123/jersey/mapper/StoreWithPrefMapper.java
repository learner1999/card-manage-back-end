package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.StoreSort;
import com.zheteng123.jersey.pojo.StoreWithPref;

import java.util.List;

/**
 * Created on 2016/11/22.
 */
public interface StoreWithPrefMapper {


    List<StoreWithPref> selectAllLazyLoading();

    List<StoreWithPref> selectByCategoryLazyLoading(String category);

    List<StoreWithPref> selectByNameLazyLoading(String name);

     int selectStoreCount(String category);

    List<StoreWithPref> selectStoreByPageNow(StoreSort storeSort);
}
