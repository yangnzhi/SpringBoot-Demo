package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/8
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class RestfullController05 {

    @RequestMapping("/boot/testRestFull/user/{id}/{name}")
    public Object testRestFull(@PathVariable("id") Integer id,
                                @PathVariable("name") String name){
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }

    @RequestMapping("/boot/testRestFull/{id}/user/{name}")
    public Object testRestFull2(@PathVariable("id") Integer id,
                               @PathVariable("name") String name){
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}