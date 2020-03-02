package com.youngnzhi.mq.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author: youngnzhi
 * @description: 非持久版/持久版
 * @date: 2020/3/1
 */
@Component
public class TopicConsumer {

    /**
     * 非持久版
     * @param textMessage
     * @throws JMSException
     */
    /*@JmsListener(destination = "${myTopicName}")
    public void getMsg(TextMessage textMessage) throws JMSException {
        System.out.println("topic 消费者收到的消息:   " + textMessage.getText());
    }
*/
    /**
     * 持久版 需要在监听方法指定连接工厂
     * @param textMessage
     * @throws JMSException
     */
    @JmsListener(destination = "${myTopicName}",containerFactory = "jmsListenerContainerFactory")
    public void getMsg2(TextMessage textMessage) throws JMSException {
        System.out.println("持久版 topic 消费者收到的消息:   " + textMessage.getText());
    }
}
