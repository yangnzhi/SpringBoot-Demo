package com.youngnzhi.mq.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author: youngnzhi
 * @description: Queue消息消费者
 * @date: 2020/3/1
 */
@Component
public class QueueConsumer {

    //监听接收的方法
//    @JmsListener(destination = "${myQueueName}")
//    public void reciveMsg(TextMessage textMessage) throws JMSException {
//        String text = textMessage.getText();
//        System.out.println("queue消费者收到的消息:   " + text);
//    }
}
