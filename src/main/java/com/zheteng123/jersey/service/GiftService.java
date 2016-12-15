package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.GiftMapper;
import com.zheteng123.jersey.pojo.Gift;
import com.zheteng123.jersey.pojo.GiftExample;
import com.zheteng123.jersey.pojo.OrderForGift;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by feige_com on 2016/11/24.
 */
public class GiftService {
    private GiftMapper giftMapper;

    public GiftService(){
        SqlSession sqlSession = DbUtils.getSqlSession(true);
        giftMapper = sqlSession.getMapper(GiftMapper.class);
    }

    /**
     * 查询兑换商品信息
     * @param example
     * @return
     */
    public int countByExample(GiftExample example){
        return  giftMapper.countByExample(example);
    }

    /**
     * 删除商品信息
     * @param example
     * @return
     */
   public  int deleteByExample(GiftExample example){
       return  giftMapper.deleteByExample(example);
   }

    /**
     * 删除商品信息
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){

        return giftMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增商品信息
     * @param record
     * @return
     */
    public int insert(Gift record){
        return  giftMapper.insert(record);
    }

    /**
     * 新增商品信息
     * @param record
     * @return
     */
    public int insertSelective(Gift record){
        record.setId(0);
        return giftMapper.insertSelective(record);
    }

    /**
     * 查询所有商品信息
     * @param example
     * @return
     */
    public List<Gift> selectByExample(GiftExample example){
        return giftMapper.selectByExample(example);
    }


    /**
     * 查询商品信息
     * @param id
     * @return
     */
   public Gift selectByPrimaryKey(Integer id){

       return giftMapper.selectByPrimaryKey(id);
   }





    /**
     * 更新商品信息
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") Gift record, @Param("example") GiftExample example){
        return giftMapper.updateByExampleSelective(record, example);
    }

    /**
     * 更新商品信息
     * @param record
     * @param example
     * @return
     */
   public int updateByExample(@Param("record") Gift record, @Param("example") GiftExample example){
       return giftMapper.updateByExample(record, example);
   }

    /**
     * 更新商品信息
     * @param id
     * @param record
     * @return
     */
   public int updateByPrimaryKeySelective(int id,Gift record){
       record.setId(id);
       return giftMapper.updateByPrimaryKeySelective(record);
   }

    /**
     * 更新商品信息
     * @param record
     * @return
     */
   public int updateByPrimaryKey(Gift record){
       return giftMapper.updateByPrimaryKey(record);
   }


    /**
     * 根据商家id查询礼品信息
     * @param storeId 商家id
     * @return 礼品信息列表
     */
    public List<Gift> selectByStoreId(int storeId) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        GiftMapper mapper = sqlSession.getMapper(GiftMapper.class);
        GiftExample example = new GiftExample();
        example.or().andStoreIdEqualTo(storeId);
        List<Gift> gifts = mapper.selectByExample(example);
        sqlSession.close();
        return gifts;
    }

    /**
     * 筛选礼品信息
     * @param orderForGift
     * @return
     */

    public List<Gift> selectBy(OrderForGift orderForGift) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        GiftMapper mapper = sqlSession.getMapper(GiftMapper.class);
        List<Gift> gifts = mapper.selectBy(orderForGift);
        sqlSession.close();
        return gifts;
    }
}
