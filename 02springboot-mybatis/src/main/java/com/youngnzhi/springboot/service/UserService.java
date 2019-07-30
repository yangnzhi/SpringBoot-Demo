package com.youngnzhi.springboot.service;

import com.youngnzhi.springboot.entities.Dept;
import com.youngnzhi.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> listUser();

    public int updateUser();

    public List<Dept> listDept();
}
