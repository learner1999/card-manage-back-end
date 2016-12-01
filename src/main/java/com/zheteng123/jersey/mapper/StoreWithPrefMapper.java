package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.StoreWithPref;

import java.util.List;

/**
 * Created on 2016/11/22.
 */
public interface StoreWithPrefMapper {

    public List<StoreWithPref> selectAllLazyLoading();

    public List<StoreWithPref> selectByCategoryLazyLoading(String category);
}
