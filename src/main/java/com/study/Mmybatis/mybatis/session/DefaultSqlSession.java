package com.study.Mmybatis.mybatis.session;

import com.study.Mmybatis.conf.Configuration;
import com.study.Mmybatis.mybatis.proxy.Daoproxy;
import com.study.Mmybatis.utils.DataSourceutils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author spin
 * @date 2021/5/24 22:02
 * @description: TODO
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Connection getConnection() {
        Connection connection = DataSourceutils.getConnection(configuration);
        this.connection = connection;
        return connection;
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass}
        ,new Daoproxy(configuration.getMappers(),this.getConnection()));
    }

    @Override
    public void close() {
        if(connection != null) {
            try{
                connection.close();
            }catch (SQLException E) {
            }
        }
    }
}
