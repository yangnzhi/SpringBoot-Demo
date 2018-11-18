package com.youngnzhi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorldController03 {

    @RequestMapping("/boot/helloworld")
    public @ResponseBody Map helloworld(){
        Map model = new HashMap();
        model.put("helloworld","youngnzhi");
        return model;
    }
}
