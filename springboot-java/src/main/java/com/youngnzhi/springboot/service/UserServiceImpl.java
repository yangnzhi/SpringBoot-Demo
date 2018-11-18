package com.youngnzhi.springboot.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: youngnzhi
 * Date: 2018/11/15
 * Time: 21:28
 * Description：
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName(String name) {
        return "hello "+name;
    }
}