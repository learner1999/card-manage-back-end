package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.MemberMapper;
import com.zheteng123.jersey.mapper.StoreWithPrefMapper;
import com.zheteng123.jersey.pojo.*;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/12/14.
 */
public class CardViewInfoService {

    /**
     * 根据用户id查询出Android端需要的会员信息
     * @param userId 用户id
     * @return 会员信息列表
     */
    public List<CardViewInfo> selectByUserId(int userId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        List<CardViewInfo> cardViewInfoList = new ArrayList<>();

        MemberExample example = new MemberExample();
        example.or().andUserIdEqualTo(userId);
        List<Member> members = mapper.selectByExample(example);

        StoreWithPrefMapper storeWithPrefMapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        MemberLevelService memberLevelService = new MemberLevelService();
        for (Member member : members) {
            StoreWithPref storeWithPref = storeWithPrefMapper.selectByPrimaryKeyLazyLoading(member.getStoreId());
            List<MemberLevel> memberLevelList = memberLevelService.findMemberLevelByStoreId(member.getStoreId());

            CardViewInfo cardViewInfo = new CardViewInfo();
            cardViewInfo.setPic(storeWithPref.getPreferential().getCardLogo());
            cardViewInfo.setBarcode(member.getCardNum());
            cardViewInfo.setMemberId(member.getId());
            cardViewInfo.setStoreId(member.getStoreId());
            cardViewInfo.setTitle(storeWithPref.getName());
            cardViewInfo.setVirtual(true);

            memberLevelList.sort((o1, o2) -> o2.getPoint() - o1.getPoint());
            for (int i = 0, len = memberLevelList.size(); i < len; i++) {
                MemberLevel memberLevel = memberLevelList.get(i);
                if (member.getPoint() >= memberLevel.getPoint()) {
                    cardViewInfo.setLevel(memberLevel.getLevel());
                    cardViewInfo.setSale(memberLevel.getDiscount());
                    break;
                }
            }

            cardViewInfoList.add(cardViewInfo);
        }

        sqlSession.close();
        return cardViewInfoList;
    }
}
