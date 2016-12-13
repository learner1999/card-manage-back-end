package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.Store;

import java.util.List;

/**
 * Created on 2016/10/17.
 */
public interface StoreMapper {

    Store findStoreByLoginInfo(LoginInfo loginInfo);

    List<Store> findStoreAll();

    List<Store> findStoreByCategory(String category);

    Store findStoreByOwnerTelephone(String telephone);

    int addStore(Store store);

    Store findStoreById(int id);

    int updateByPrimaryKey(Store store);

    Store findByPrimaryKey(int id);
}
