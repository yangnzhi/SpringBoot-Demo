package com.youngnzhi.mq;

import com.youngnzhi.mq.consumers.QueueConsumer;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jms.JMSException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Mq4ConsumerApplication.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private QueueConsumer queueConsumer;

    /*@Test
    public void ConsumerGetMsg() {
        try {
            queueConsumer.reciveMsg(new ActiveMQTextMessage());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }*/

}
