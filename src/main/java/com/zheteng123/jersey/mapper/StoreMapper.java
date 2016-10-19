package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.LoginInfo;
import com.zheteng123.jersey.pojo.Store;

/**
 * Created on 2016/10/17.
 */
public interface StoreMapper {

    Store findStoreByLoginInfo(LoginInfo loginInfo);

    Store findStoreByOwnerTelephone(String telephone);

    int addStore(Store store);
}
