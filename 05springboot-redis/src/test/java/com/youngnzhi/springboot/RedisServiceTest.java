package com.youngnzhi.springboot;

import com.youngnzhi.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.*;

/**
 * @author: youngnzhi
 * @description: com.youngnzhi.springboot
 * @date: 2019/8/20
 */
@SpringBootTest(classes = SpringbootRedisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RedisServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 模拟1w并发访问
     */
    @Test
    public void testSynchronized(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                userService.listUser();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);//创建线程池

        for (int i = 0;i<100;i++){
            if(!executorService.isShutdown()){
                executorService.submit(runnable);
            }
        }
    }
}
