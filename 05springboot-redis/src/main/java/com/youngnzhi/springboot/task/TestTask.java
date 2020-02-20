package com.youngnzhi.springboot.task;

import com.youngnzhi.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: youngnzhi
 * @description: com.youngnzhi.springboot.task
 * @date: 2019/8/24
 */
@Slf4j
@Component
public class TestTask {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 5 19 * * ?")
    public void testTask(){
        log.info("start: " + new Date());
        userService.addUser();
        log.info("end: "   + new Date());
    }

    @Scheduled(cron = "0 5 09 * * ?")
    public void testTask2(){
        log.info("start: " + new Date());
        userService.addUser();
        log.info("end: "   + new Date());
    }

    @Scheduled(cron = "0 15 21 * * ?")
    public void testTask3(){
        log.info("start: " + new Date());
        userService.addUser();
        log.info("end: "   + new Date());
    }
}
