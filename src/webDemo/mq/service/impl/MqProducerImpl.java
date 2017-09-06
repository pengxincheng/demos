package webDemo.mq.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webDemo.MqProducer;

/**
 * Created by pxc on 2017/6/28.
 */
@Service
public class MqProducerImpl implements MqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
