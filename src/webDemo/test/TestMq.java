package webDemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webDemo.MqProducer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pxc on 2017/6/28.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})

public class TestMq{
    @Autowired
    private MqProducer mqProducer;

    final String queue_key = "test_queue_key";

    @Test
    public void send(){
        Map<String,Object> msg = new HashMap<String,Object>();
        msg.put("data","hello,rabbmitmq!");
        msg.put("chinese","你好！");
        mqProducer.sendDataToQueue(queue_key,msg);
    }
}
