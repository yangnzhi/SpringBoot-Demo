package com.youngnzhi.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youngnzhi.springboot.entities.Dept;
import com.youngnzhi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 2019-07-30 测试pagehelper临时添加
     * @return
     */
    @GetMapping("/listDept")
    public Object listDept(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> depts= userService.listDept();
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(depts);
        return pageInfo;
    }

}
