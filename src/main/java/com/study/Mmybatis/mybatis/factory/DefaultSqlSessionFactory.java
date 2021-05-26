package com.study.Mmybatis.mybatis.factory;

import com.study.Mmybatis.conf.Configuration;
import com.study.Mmybatis.mybatis.session.DefaultSqlSession;
import com.study.Mmybatis.mybatis.session.SqlSession;

/**
 * @author spin
 * @date 2021/5/24 22:01
 * @description: TODO
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public SqlSession openSession() {
        System.out.println("Factoryconfiguration="+configuration);
        return new DefaultSqlSession(configuration);
    }
}
