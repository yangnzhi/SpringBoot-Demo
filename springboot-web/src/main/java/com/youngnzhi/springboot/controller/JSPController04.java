package com.youngnzhi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController04 {

    @GetMapping("/boot/resoverJsp")
    public String resoverJsp(Model model) {
        model.addAttribute("msg","springboot 集成 jsp");
        return "resoverJsp";
    }
}
