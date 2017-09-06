package baseDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by pxc on 2017/6/27.
 */
public class Send {
    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        /**
         * 创建连接MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost("localhost");
        //创建一个连接
        Connection connection = null;
        try {
            connection = factory.newConnection();
            //创建一个频道
            Channel channel = connection.createChannel();
            //指定一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world!";
            while (!message.equals("0")){
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入要发送的消息：");
                message = scanner.nextLine();
                //往队列中发出一条消息
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            }
            //发送的消息

            //关闭频道和连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
