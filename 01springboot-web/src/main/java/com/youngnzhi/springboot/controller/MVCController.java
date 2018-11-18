package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.model.User;
import org.springframework.web.bind.annotation.*;

/*
@RestController == @Controller + @ResponseBody
表示这个类下面的所有方法都以字符串或者json格式返回数据
 */
@RestController
public class MVCController {

    @RequestMapping("/transUser")
    public Object transUser() {
        User user = new User();
        user.setSex("男");
        user.setAddress("天府五街");
        return user;
    }

    /*
     @GetMapping("/transUserByGetMethod") == @RequestMapping(value = "/transUserByGetMethod",method = RequestMethod.GET )
     表示这个方法以get方式请求
     */
    @GetMapping("/boot/transUserByGetMethod")
    public Object transUserByGetMethod() {
        User user = new User();
        user.setSex("男");
        user.setAddress("天府五街");
        return user;
    }

    /*
     @PostMapping("/transUserByPostMethod") == @RequestMapping(value = "/transUserByGetMethod",method = RequestMethod.POST )
     表示这个方法以post方式请求，post请求用于表单提交，这个方法不属于表单提交，前台请求时这里会报错
     */
    @PostMapping("/boot/transUserByPostMethod")
    public Object transUserByPostMethod() {
        User user = new User();
        user.setSex("男");
        user.setAddress("天府五街");
        return user;
    }

    /*
    @PutMapping 表示修改数据，一般用的少，用 @PostMapping 代替
    @DeleteMapping 表示删除数据，一般用得少，一般通过传递id到后台进行删除，用 @GetMapping 代替
    */
}
