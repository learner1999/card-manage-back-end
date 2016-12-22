package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.MemberWithUserMapper;
import com.zheteng123.jersey.pojo.MemberLevel;
import com.zheteng123.jersey.pojo.MemberWithUser;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created on 2016/12/20.
 */
public class MemberWithUserService {

    /**
     * 根据商家id查询会员信息（包含会员的基本用户信息）
     * @param storeId 商家id
     * @return 会员信息列表
     */
    public List<MemberWithUser> selectByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        MemberWithUserMapper mapper = sqlSession.getMapper(MemberWithUserMapper.class);

        List<MemberWithUser> memberWithUsers = mapper.selectByStoreIdLazyLoading(storeId);

        MemberLevelService memberLevelService = new MemberLevelService();
        List<MemberLevel> memberLevels = memberLevelService.findMemberLevelByStoreId(storeId);

        for (MemberWithUser memberWithUser : memberWithUsers) {
            memberLevels.sort((o1, o2) -> o2.getPoint() - o1.getPoint());
            for (MemberLevel memberLevel : memberLevels) {
                if (memberLevel.getPoint() < memberWithUser.getPoint()) {
                    memberWithUser.setLevel(memberLevel.getLevel());
                    break;
                }
            }
        }

        sqlSession.close();
        return memberWithUsers;
    }
}
