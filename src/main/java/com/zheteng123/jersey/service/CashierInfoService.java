package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.CashierInfoMapper;
import com.zheteng123.jersey.mapper.StoreWithPrefMapper;
import com.zheteng123.jersey.pojo.CashierInfo;
import com.zheteng123.jersey.pojo.CashierSearchInfo;
import com.zheteng123.jersey.pojo.MemberLevel;
import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/12/9.
 */
public class CashierInfoService {

    /**
     * 根据卡号或用户名查询当前用户在当前商家的信息
     * @param id 卡号或用户名
     * @param storeId 商家id
     * @return 用户信息
     */
    public CashierInfo getByIdAndStoreId(String id, int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        CashierInfoMapper cashierInfoMapper = sqlSession.getMapper(CashierInfoMapper.class);

        // 联查用户表及会员表
        CashierSearchInfo cashierSearchInfo = new CashierSearchInfo();
        cashierSearchInfo.setId(id);
        cashierSearchInfo.setStoreId(storeId);
        CashierInfo cashierInfo = cashierInfoMapper.findByUsernameOrMemberId(cashierSearchInfo);
        if (cashierInfo == null) {
            return null;
        }

        // 查询商家部分信息
        StoreWithPrefMapper storeWithPrefMapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        StoreWithPref storeWithPref = storeWithPrefMapper.selectByPrimaryKeyLazyLoading(storeId);
        cashierInfo.setExchange(storeWithPref.getPreferential().getExchangeScore());

        // 查询会员等级及折扣
        MemberLevelService memberLevelService = new MemberLevelService();
        List<MemberLevel> memberLevels = memberLevelService.findMemberLevelByStoreId(storeId);
        memberLevels.sort((o1, o2) -> o2.getPoint() - o1.getPoint());
        for (MemberLevel memberLevel : memberLevels) {
            if (memberLevel.getPoint() < cashierInfo.getPoint()) {
                cashierInfo.setLevel(memberLevel.getLevel());
                cashierInfo.setDiscount(memberLevel.getDiscount());
                break;
            }
        }

        sqlSession.close();

        return cashierInfo;
    }
}
