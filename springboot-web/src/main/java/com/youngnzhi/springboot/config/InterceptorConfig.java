package com.youngnzhi.springboot.config;

import com.youngnzhi.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/12
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
@Configuration //启动时读取配置 与SpringbootWebApplication同目录或者其同目录的子目录下
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截的路径
        String[] addPathPatterns = {
                "/boot/**",
                "/transUser"
        };
        //不拦截的路径
        String[] excludePathPatterns = {
                "/boot/helloworld"
        };
        //注册登录拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
        //注册权限拦截器
        //registry.addInterceptor(new AuthInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}