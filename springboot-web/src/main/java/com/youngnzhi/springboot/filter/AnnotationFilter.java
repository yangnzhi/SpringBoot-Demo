package com.youngnzhi.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/14
 * Time: 20:59
 * Description：编写一个Servlet3的注解过滤器
 */
@WebFilter(urlPatterns = "/*") //过滤所有页面
public class AnnotationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---正在使用注解过滤器---");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}