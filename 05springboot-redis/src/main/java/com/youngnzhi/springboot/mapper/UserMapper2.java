package com.youngnzhi.springboot.mapper;

import com.youngnzhi.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: youngnzhi
 * @description: com.youngnzhi.springboot.mapper
 * @date: 2019/8/25
 */
@Mapper
public interface UserMapper2 {

    @Select("insert into user (id, username, birthday, sex, address,createDate,type)\n" +
            "values (#{id}, #{username},#{birthday},#{sex}, #{address},#{createDate},#{type}) ")
    void addUser(User user);
}
