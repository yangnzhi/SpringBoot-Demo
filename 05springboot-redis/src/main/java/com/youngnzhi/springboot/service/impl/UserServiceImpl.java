package com.youngnzhi.springboot.service.impl;

import com.youngnzhi.springboot.entities.Dept;
import com.youngnzhi.springboot.mapper.DeptDao;
import com.youngnzhi.springboot.mapper.UserMapper;
import com.youngnzhi.springboot.mapper.UserMapper2;
import com.youngnzhi.springboot.model.User;
import com.youngnzhi.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper2 userMapper2;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<User> listUser() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);// redis存储时，key序列化，不然会保存无阅读性的key,值不用序列化

        //高并发条件下，存在缓存穿透问题
        // 问题： 1w个用户同时访问，同时判断缓存为空，同时去数据库查询数据，增加数据库压力
        //查询缓存
        List<User> userList = (List<User>) redisTemplate.opsForValue().get("listUser2");

        //双重检测锁
        /**
         *  1w个用户同时取缓存，同时判断是否为空，一个用户获得锁，其他用户处于等待状态
         *  获得锁的用户再次取缓存，再次判断是否为空，此时为空，读数据库数据写入缓存
         *  后面的用户获得锁，再次取缓存，再次判断，缓存不为空，跳过数据库，返回数据
         *  1w个之后的用户取缓存，首先判断不为空，不用进入判断内部取获取锁，直接返回缓存数据
         */
        if(CollectionUtils.isEmpty(userList)){
            synchronized (this){
                //获取锁之后，再次取缓存
                userList = (List<User>) redisTemplate.opsForValue().get("listUser2");
                if(StringUtils.isEmpty(userList)){
                    System.out.println("查询来自数据库。。。。。。");
                    //缓存为空，再查一遍数据库
                    userList = userMapper.listUser();
                    //把查询出来的数据放入缓存中
                    redisTemplate.opsForValue().set("listUser2",userList);//redis存储要序列化对象，user要先序列化
                } else {
                    System.out.println("查询来自缓存。。。。。。");
                }
            }
        } else {
            System.out.println("查询来自缓存。。。。。。");
        }

        return userList;
    }

    @Transactional//在访问数据库的Service方法上添加注解 @Transactional 即可;
    @Override
    public int updateUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setSex("1");
        user.setAddress("成都");
        user.setCreateDate(new Date());
        user.setType("system");
        int count = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(count);

        //int i = 1 / 0 ;//测试是否回滚
        return count;
    }

    /**
     * 2019-07-30 测试pagehelper临时添加
     * @return
     */
    @Override
    public List<Dept> listDept() {
        return deptDao.findAll();
    }

    @Override
    @Transactional
    public void addUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setSex("1");
        user.setAddress("成都2");
        user.setCreateDate(new Date());
        user.setType("system");
        user.setUsername("kevin");
        user.setBirthday(new Date());
        userMapper2.addUser(user);
    }
}
