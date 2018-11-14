package com.youngnzhi.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
application.properties中自定义配置信息： youngnzhi.sex=男
    prefix对应配置信息的前缀 (prefix = "youngnzhi")
    class类中属性对应配置信息中前缀后面定义信息 private String sex;
 */
@Component
@ConfigurationProperties(prefix = "youngnzhi")
public class ConfigInfo {

    private String sex;
    private String address;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
