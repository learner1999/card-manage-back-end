package com.zheteng123.jersey.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by shuaiquan on 2016/10/9.
 */
public class DbUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 初始化sqlSessionFactory
     */
    private static void initSqlSessionFactory(){
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(getCoreConfig());
    }

    /**
     * 读取mybatils的核心配置文件
     * @InputStream
     */
    private static Reader getCoreConfig(){
        String url = "SqlMapConfig.xml";
        Reader config  = null;

        try{
            config = Resources.getResourceAsReader(url);
        }catch(IOException e){
            e.printStackTrace();
        }

        return config;
    }

    /**
     * 返回一个sqlSession实例
     * @SqlSession
     */
    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        System.out.println(sqlSessionFactory);
        return sqlSessionFactory.openSession();
    }
}
