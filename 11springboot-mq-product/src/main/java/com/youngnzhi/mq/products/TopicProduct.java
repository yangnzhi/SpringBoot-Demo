package com.youngnzhi.mq.products;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author: youngnzhi
 * @description: com.youngnzhi.mq.products
 * @date: 2020/3/1
 */
@Component
public class TopicProduct {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    /**
     * 每隔3秒发送一次
     */
    @Scheduled(fixedDelay = 3000)
    public void sendMsg() {
        jmsMessagingTemplate.convertAndSend(activeMQTopic, UUID.randomUUID().toString());
        System.out.println("topic消息发送时间:   " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
