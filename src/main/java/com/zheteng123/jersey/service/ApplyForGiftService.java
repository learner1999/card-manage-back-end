package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.ApplyForGiftMapper;
import com.zheteng123.jersey.pojo.ApplyForGift;
import com.zheteng123.jersey.pojo.ApplyForGiftExample;
import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/12/13.
 */
public class ApplyForGiftService {

    /**
     * 根据主键id查询礼品兑换信息
     * @param id 主键id
     * @return 礼品兑换信息
     */
    public ApplyForGift selectByPrimaryId(int id) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        ApplyForGift applyForGift = mapper.selectByPrimaryKey(id);

        sqlSession.close();
        return applyForGift;
    }

    /**
     * 根据商家id获取礼品兑换申请信息
     * @param storeId 商家id
     * @return 兑换申请列表
     */
    public List<ApplyForGift> selectByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        GiftService giftService = new GiftService();
        List<Gift> gifts = giftService.selectByStoreId(storeId);

        List<ApplyForGift> applyForGiftList = new ArrayList<>();
        for (Gift gift : gifts) {
            ApplyForGiftExample example = new ApplyForGiftExample();
            example.or().andGiftIdEqualTo(gift.getId());
            List<ApplyForGift> applyForGifts = mapper.selectByExample(example);
            applyForGiftList.addAll(applyForGifts);
        }

        return applyForGiftList;
    }

    /**
     * 根据商家id和用户id查询相应记录
     * @param storeId 商家id
     * @param userId 用户id
     * @return 记录列表
     */
    public List<ApplyForGift> selectByStoreIdAndUserId(int storeId, int userId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        GiftService giftService = new GiftService();
        List<Gift> gifts = giftService.selectByStoreId(storeId);

        List<ApplyForGift> applyForGiftList = new ArrayList<>();
        for (Gift gift : gifts) {
            ApplyForGiftExample example = new ApplyForGiftExample();
            example.or().andGiftIdEqualTo(gift.getId()).andUserIdEqualTo(userId);
            List<ApplyForGift> applyForGifts = mapper.selectByExample(example);
            applyForGiftList.addAll(applyForGifts);
        }

        return applyForGiftList;
    }

    /**
     * 新增礼品兑换申请
     * @param applyForGift 申请信息
     * @return 是否成功
     */
    public boolean insert(ApplyForGift applyForGift) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        int counter = mapper.insert(applyForGift);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 更新指定id申请信息
     * @param applyForGift 礼品兑换申请信息
     * @param id 自增id
     * @return 是否成功
     */
    public boolean updateByPrimaryKey(ApplyForGift applyForGift, int id) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        applyForGift.setId(id);
        int counter = mapper.updateByPrimaryKey(applyForGift);

        sqlSession.close();
        return counter == 1;
    }

    /**
     * 删除指定id申请信息
     * @param id 礼品兑换申请信息
     * @return 是否成功
     */
    public boolean deleteByPrimaryKey(int id) {
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        ApplyForGiftMapper mapper = sqlSession.getMapper(ApplyForGiftMapper.class);

        int counter = mapper.deleteByPrimaryKey(id);

        sqlSession.close();
        return counter == 1;
    }
}
