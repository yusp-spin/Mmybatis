package com.study.Mmybatis.conf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author spin
 * @date 2021/5/24 21:58
 * @description: TODO
 */
public class Configuration {

    private Map<String,Mapper> mappers = new HashMap<>();

    private String Driver;

    private String username;

    private String password;

    private String url;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "mappers=" + mappers +
                ", Driver='" + Driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
