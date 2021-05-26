package com.study.Mmybatis.mybatis.io;

import java.io.InputStream;

/**
 * @author spin
 * @date 2021/5/24 22:01
 * @description: TODO
 */
public class Resources {

    /**
    * @description: TODO 获取配置信息资源
    * @author yusp
    * @date 2021/5/24 22:27
    */
    public static InputStream getResourceAsStream(String filepath) {
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
