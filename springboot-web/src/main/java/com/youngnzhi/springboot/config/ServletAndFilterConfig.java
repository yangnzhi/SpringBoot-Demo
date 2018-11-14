package com.youngnzhi.springboot.config;

import com.youngnzhi.springboot.filter.NoAnnotationFilter;
import com.youngnzhi.springboot.servlet.MyServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/12
 * Time: 23:09
 * Description：springboot没有xml配置文件，@Configuration表明是一个配置类，Servlet Config 配置文件
 */
@Configuration
public class ServletAndFilterConfig {

    /*
      使用非Servlet3的注解方式编写的Servlet，需要在configuration里面注册
      @Bean 相当于 ssm 项目中 applicationcontext.xml中配置如下bean
      <bean id="myServlet2RegistrationBean" class="org.springframework.boot.web.servlet.ServletRegistrationBean"></bean>
     */
    @Bean
    public ServletRegistrationBean myServlet2RegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new MyServlet2(), "/boot/myServlet2");
        return registration;
    }

    /*
      使用非Servlet3的注解方式编写的Filter，需要在configuration里面注册
      @Bean 相当于 ssm 项目中 applicationcontext.xml中配置如下bean
      <bean id="noAnnotationFilterRegistration" class="org.springframework.boot.web.servlet.FilterRegistrationBean"></bean>
     */
    @Bean
    public FilterRegistrationBean noAnnotationFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new NoAnnotationFilter());
        registration.addUrlPatterns("/*");//过滤路径
        return registration;
    }
}