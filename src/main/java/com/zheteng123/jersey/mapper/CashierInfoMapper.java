package com.zheteng123.jersey.mapper;

import com.zheteng123.jersey.pojo.CashierInfo;
import com.zheteng123.jersey.pojo.CashierSearchInfo;

/**
 * Created on 2016/12/9.
 */
public interface CashierInfoMapper {

    CashierInfo findByUsernameOrMemberId(CashierSearchInfo info);
}
