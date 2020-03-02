package com.youngnzhi.mq.products;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author: youngnzhi
 * @description: Queue消息生产者
 * @date: 2020/3/1
 */
@Component
public class QueueProduct {

    @Autowired
    //JmsMessagingTemplate是Springboot的Jms模板,Spring的是JmsTemplate
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    //把ActiveMqConfig类的ActiveMQQueue注入进来
    private ActiveMQQueue activeMQQueue;

    //发送Queue的方法
    /* public void productSendMsg() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, UUID.randomUUID().toString());
        System.out.println("消息发送时间:   " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }*/

    /**
     * 间隔3秒发送消息
     */
    @Scheduled(cron = "0/3 * * * * ?")
    public void productSendMsg4Scheduled() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, UUID.randomUUID().toString());
        System.out.println("queue消息发送时间:   " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
