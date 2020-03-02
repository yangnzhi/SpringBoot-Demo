package com.youngnzhi.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Mq4ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mq4ConsumerApplication.class, args);
    }

}
