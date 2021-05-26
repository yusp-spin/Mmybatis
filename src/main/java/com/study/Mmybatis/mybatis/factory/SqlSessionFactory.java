package com.study.Mmybatis.mybatis.factory;

import com.study.Mmybatis.mybatis.session.SqlSession;

/**
 * @author spin
 * @date 2021/5/24 22:01
 * @description: TODO
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
