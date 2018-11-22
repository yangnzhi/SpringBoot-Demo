package com.youngnzhi.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/18
 * Time: 18:31
 * Description：springboot 打war包部署
 */
@Controller
public class WarController {

    @RequestMapping("/boot/warDeploy")
    public String warDeploy(Model model) {
        model.addAttribute("name","youngnzhi");
        return "warJsp";
    }
}