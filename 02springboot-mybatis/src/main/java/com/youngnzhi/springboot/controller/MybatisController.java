package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @GetMapping("/listUser")
    public Object listUser(){
        return userService.listUser();
    }

    @GetMapping("/updateUser")
    public Object updateUser(){
        return userService.updateUser();
    }

}
