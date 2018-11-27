package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youngnzhi on 2018/11/22.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/boot/thymeleaf")
    private String testThymeleaf(Model model) {
        User user = new User();
        user.setName("kevin");
        user.setAddress("chengdu");
        user.setEmail("youngtest@163.com");
        user.setSex("man");

        List<User> userList = new ArrayList<User>();
        Map<String,User> userMap = new HashMap<>();
        User[] userArray = new User[5];
        for (int i = 0;i<5;i++) {
            User u = new User();
            u.setName("kevin"+i);
            u.setAddress("chengdu"+i);
            u.setEmail(i+"youngtest@163.com");
            u.setSex("man");

            userList.add(u);
            userMap.put("user"+i,u);
            userArray[i] = u;
        }
        boolean isFlag = true;

        model.addAttribute("user",user);
        model.addAttribute("userList",userList);
        model.addAttribute("userMap",userMap);
        model.addAttribute("userArray",userArray);
        model.addAttribute("isFlag",isFlag);
        model.addAttribute("curentPage",1);
        model.addAttribute("totalPage",3);

        return "view/index";
    }
}
