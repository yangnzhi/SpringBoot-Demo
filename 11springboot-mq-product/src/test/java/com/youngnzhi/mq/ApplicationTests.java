package com.youngnzhi.mq;

import com.youngnzhi.mq.products.QueueProduct;
import com.youngnzhi.mq.products.TopicProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Mq4ProductApplication.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private QueueProduct queueProduct;

    @Autowired
    private TopicProduct topicProduct;

    @Test
    public void queueSendMsg() {
        queueProduct.productSendMsg4Scheduled();
    }

    @Test
    public void topicSendMsg() {
        topicProduct.sendMsg();
    }

}
