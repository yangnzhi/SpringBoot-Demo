package com.youngnzhi.mq.configs;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author: youngnzhi
 * @description: 设置持久化订阅 配置文件的方式无法进行配置持久化订阅。所以需要自己去生成一个持久化订阅
 * @date: 2020/3/2
 */
@Configuration
@EnableJms
public class Topic4PersistentConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(user);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }


    @Bean(name = "jmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        defaultJmsListenerContainerFactory.setSubscriptionDurable(true);
        defaultJmsListenerContainerFactory.setClientId("我是持久订阅者一号");
        return defaultJmsListenerContainerFactory;
    }

}
