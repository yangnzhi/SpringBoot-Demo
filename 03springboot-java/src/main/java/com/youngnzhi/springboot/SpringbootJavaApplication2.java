package com.youngnzhi.springboot;

import com.youngnzhi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringbootJavaApplication2 implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaApplication2.class, args);//springboot项目入口，启动springboot项目，启动spring容器，这里不会启动内置tomcat

        /*
        小知识点:有时候公司上线项目要求日志不打印出 spring logo

        SpringApplication springApplication = new SpringApplication(SpringbootJavaApplication2.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
         */
    }

    @Override
    public void run(String... args) throws Exception {
        String hi = userService.getUserName("kevin");
        System.out.println(hi);
    }
}
