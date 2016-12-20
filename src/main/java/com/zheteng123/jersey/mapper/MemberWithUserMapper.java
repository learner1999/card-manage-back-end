package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.MemberWithUser;

import java.util.List;

/**
 * Created on 2016/12/19.
 */
public interface MemberWithUserMapper {

    List<MemberWithUser> selectByStoreIdLazyLoading(int storeId);
}
