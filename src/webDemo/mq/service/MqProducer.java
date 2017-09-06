package webDemo;

/**
 * Created by pxc on 2017/6/28.
 */
public interface MqProducer {

    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    void sendDataToQueue(String queueKey, Object object);
}
