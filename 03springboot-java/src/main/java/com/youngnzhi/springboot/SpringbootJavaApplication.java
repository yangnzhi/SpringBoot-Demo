package com.youngnzhi.springboot;

import com.youngnzhi.springboot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class SpringbootJavaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJavaApplication.class, args);
        UserService userService = (UserService)context.getBean("userServiceImpl");
        String hi = userService.getUserName("kevin");
        System.out.println(hi);
    }
}
