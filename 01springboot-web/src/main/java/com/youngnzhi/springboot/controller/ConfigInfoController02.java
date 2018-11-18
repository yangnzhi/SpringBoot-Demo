package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigInfoController02 {

    @Value("${youngnzhi.sex}")//读取配置文件中的配置信息
    private String sex;

    @Value("${youngnzhi.address}")
    private String address;

    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/boot/config")
    private @ResponseBody String getConfig() {
        return sex + "---" + address + " === " + configInfo.getSex() + "---" + configInfo.getAddress();
    }

}
