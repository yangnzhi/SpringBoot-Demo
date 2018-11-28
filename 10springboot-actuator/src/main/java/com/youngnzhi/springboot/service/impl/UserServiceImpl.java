package com.youngnzhi.springboot.service.impl;

import com.youngnzhi.springboot.mapper.UserMapper;
import com.youngnzhi.springboot.model.User;
import com.youngnzhi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Transactional//在访问数据库的Service方法上添加注解 @Transactional 即可；
    @Override
    public int updateUser() {
        User user = new User();
        user.setId(1);
        user.setSex("1");
        user.setAddress("成都");
        int count = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(count);

        //int i = 1 / 0 ;//测试是否回滚
        return count;
    }
}
