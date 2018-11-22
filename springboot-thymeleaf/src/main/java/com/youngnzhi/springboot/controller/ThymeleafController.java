package com.youngnzhi.springboot.controller;

import com.youngnzhi.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("user",user);
        return "index";
    }
}
