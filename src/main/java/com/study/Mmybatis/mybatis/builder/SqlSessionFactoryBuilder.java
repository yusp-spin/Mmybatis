package com.study.Mmybatis.mybatis.builder;

import com.study.Mmybatis.conf.Configuration;
import com.study.Mmybatis.mybatis.factory.DefaultSqlSessionFactory;
import com.study.Mmybatis.mybatis.factory.SqlSessionFactory;
import com.study.Mmybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author spin
 * @date 2021/5/24 22:00
 * @description: TODO 获取SqlSessionFactory对象的，将输入的config转为config对象
 */
public class SqlSessionFactoryBuilder {
    public static SqlSessionFactory build(InputStream config) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        System.out.println("configuration:"+configuration);
        return new DefaultSqlSessionFactory(configuration);
    }
}
