package com.study.Mmybatis.mybatis.session;

import java.sql.Connection;

/**
 * @author spin
 * @date 2021/5/24 22:04
 * @description: TODO
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();

    Connection getConnection();

}
