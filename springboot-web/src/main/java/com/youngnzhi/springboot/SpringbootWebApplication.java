package com.youngnzhi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.youngnzhi.springboot.servlet","com.youngnzhi.springboot.filter"})
// 结合@WebServlet(urlPatterns = "/boot/myServlet") @WebFilter("/*") 使用
public class SpringbootWebApplication {

    public static void main(String[] args) {
        //启动springboot程序，启动spring容器，启动内嵌的tomcat
        SpringApplication.run(SpringbootWebApplication.class, args);
    }
}
