package com.study.Mmybatis.mybatis.proxy;

import com.study.Mmybatis.conf.Mapper;
import com.study.Mmybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author spin
 * @date 2021/5/24 22:01
 * @description: TODO
 */
public class Daoproxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection connection;

    public Daoproxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodname = method.getName();
        String classname = method.getDeclaringClass().getName();
        System.out.println("classname="+classname);
        System.out.println("methodname="+methodname);
        System.out.println("connection="+connection);
        String key = classname+"."+methodname;
        Mapper mapper = mappers.get(key);
        return new Executor().selectList(mapper,connection);
    }
}
