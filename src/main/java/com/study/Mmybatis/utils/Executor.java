package com.study.Mmybatis.utils;

import com.study.Mmybatis.conf.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author spin
 * @date 2021/5/24 22:05
 * @description: TODO
 */
public class Executor {
    public <E> List<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //取出mapper数据
            String queryString = mapper.getQueryString();
            String resultType = mapper.getResultType();
            Class domainClass = Class.forName(resultType);
            pstm = conn.prepareStatement(queryString);
            rs = pstm.executeQuery();
            List<E> list = new ArrayList<>();
            while(rs.next()) {
                E obj = (E)domainClass.newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 0; i <= columnCount ; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, domainClass);
                    Method writeMethod = pd.getWriteMethod();
                    writeMethod.invoke(obj,columnValue);
                }
                list.add(obj);
            }
            return list;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            release(pstm,rs);
        }
    }

    private void release(PreparedStatement pstm, ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(pstm != null) {
            try{
                pstm.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
