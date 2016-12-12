package com.zheteng123.jersey.service;

import com.zheteng123.jersey.mapper.StoreWithPrefMapper;
import com.zheteng123.jersey.pojo.StoreSort;
import com.zheteng123.jersey.pojo.StoreWithPref;
import com.zheteng123.jersey.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/11/22.
 */
public class StoreWithPrefService {
    private int PageSize=10;//希望一页有多少条数据
    private int PageCount=0;//总共有多少页
    private List<StoreSort> mStoreSort=new ArrayList<StoreSort>();

    /**
     * 查询所有商家信息（包含优惠信息）
     * @return 商家信息列表
     */
    public List<StoreWithPref> getStoreWithPrefAll() {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectAllLazyLoading();
        sqlSession.close();
        return storeWithPrefs;
    }

    /**
     * 根据类别查询商家信息（包含优惠信息）
     * @param category 类别
     * @return 商家信息列表
     */
    public List<StoreWithPref> getStoreWithPrefByCategory(String category) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectByCategoryLazyLoading(category);
        sqlSession.close();
        return storeWithPrefs;
    }

    public List<StoreWithPref> getStoreWithPrefByName(String name) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectByNameLazyLoading(name);
        sqlSession.close();
        return  storeWithPrefs;
    }

    /**
     * 查询不同类型(category)的商家的总页数
     * @param category
     * @return
     */
    public int getStoreCategoryCount(String category){
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        int Count=mapper.selectStoreCategoryCount(category);
        if(Count%PageSize==0){
            PageCount=Count/PageSize;
        }else{
            PageCount=(Count/PageSize)+1;
        }
        sqlSession.close();
        return PageCount;
    }

    /**
     * 获得所有的点店铺的总页数
     * @return
     */
    public int getStoreCount(){
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        int Count=mapper.selectStoreCount();
        if(Count%PageSize==0){
            PageCount=Count/PageSize;
        }else{
            PageCount=(Count/PageSize)+1;
        }
        sqlSession.close();
        return PageCount;
    }



    /**
     * 查询不同类型(sort)的商家的总页数
     * @param sort
     * @return
     */
    public int getStoreSortCount(String sort){
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        inis(sort);
        int Count=mapper.selectStoreSortCount(mStoreSort);
        if(Count%PageSize==0){
            PageCount=Count/PageSize;
        }else{
            PageCount=(Count/PageSize)+1;
        }
        sqlSession.close();
        return PageCount;
    }


    /**
     * 查询指定category和第几页的商家信息
     * @param storeSort
     * @return
     */
    public List<StoreWithPref> getStoreCategoryByPageNow(StoreSort storeSort) {
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        storeSort.setPagenow((storeSort.getPagenow()-1)*PageSize);
        List<StoreWithPref> storeWithPrefs = mapper.selectStoreCategoryByPagenow(storeSort);
        sqlSession.close();
        return storeWithPrefs;
}

    /**
     * 查询指定sort和第几页的商家信息
     * @param pagenow
     * @param sort
     * @return
     */
    public List<StoreWithPref> getStoreSortByPageNow(int pagenow,String sort){
        inis(sort);
        pagenow=(pagenow-1)*PageSize;
        SqlSession sqlSession = DbUtils.getSqlSession();
        StoreWithPrefMapper mapper = sqlSession.getMapper(StoreWithPrefMapper.class);
        List<StoreWithPref> storeWithPrefs = mapper.selectStoreSortByPagenow(pagenow,mStoreSort);
        sqlSession.close();
        return storeWithPrefs;
    }

    /**
     * 初始化mStoreSort，
     * @param sort
     */
    public void inis(String sort){
      if("购物".equals(sort)){
          StoreSort storeSort=new StoreSort();
          storeSort.setCategory("时尚");
          mStoreSort.add(storeSort);
          StoreSort storeSort1=new StoreSort();
          storeSort1.setCategory("美妆");
          mStoreSort.add(storeSort1);
          StoreSort storeSort2=new StoreSort();
          storeSort2.setCategory("珠宝");
          mStoreSort.add(storeSort2);

      }
        else if("餐饮".equals(sort)){
          StoreSort storeSort=new StoreSort();
          storeSort.setCategory("餐饮");
          mStoreSort.add(storeSort);
          StoreSort storeSort1=new StoreSort();
          storeSort1.setCategory("超市");
          mStoreSort.add(storeSort1);

      }else if("旅游".equals(sort)){
          StoreSort storeSort=new StoreSort();
          storeSort.setCategory("酒店");
          mStoreSort.add(storeSort);
          StoreSort storeSort1=new StoreSort();
          storeSort1.setCategory("国际");
          mStoreSort.add(storeSort1);
      }

      else if("休闲".equals(sort)){
          StoreSort storeSort=new StoreSort();
          storeSort.setCategory("健身");
          mStoreSort.add(storeSort);
          StoreSort storeSort1=new StoreSort();
          storeSort1.setCategory("娱乐");
          mStoreSort.add(storeSort1);
          StoreSort storeSort2=new StoreSort();
          storeSort2.setCategory("其他");
          mStoreSort.add(storeSort2);
      }
    }


}
