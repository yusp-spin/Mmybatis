package com.study.Mmybatis.utils;

import com.study.Mmybatis.conf.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author spin
 * @date 2021/5/24 22:05
 * @description: TODO
 */
public class DataSourceutils {
    public static Connection getConnection(Configuration cfg) {
        try{
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
