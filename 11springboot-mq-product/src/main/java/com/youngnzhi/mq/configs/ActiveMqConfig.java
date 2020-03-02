package com.youngnzhi.mq.configs;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author: youngnzhi
 * @description: 配置bean,类似于Spring的ApplicationContext.xml文件
 * @date: 2020/3/1
 */
@Configuration
@EnableJms //开启Springboot的Jms
public class ActiveMqConfig {

    @Value("${myQueueName}")
    private String queue_name;

    @Value("${myTopicName}")
    private String topic_name;

    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue(queue_name);
    }

    @Bean
    public ActiveMQTopic topic() {
        return new ActiveMQTopic(topic_name);
    }
}
