package com.lovego.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Created by qinwei on 2017/11/14.
 */
public class Produce {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
//		设置RabbitMQ地址
        factory.setHost("192.168.31.200");
//		创建一个新的连接
        Connection connection = factory.newConnection();
//		创建一个频道
        Channel channel = connection.createChannel();
//		声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。

        //队列名称
        //在服务器重启时，能够存活
        // 是否为当前连接的专用队列，在连接断开后，会自动删除该队列，生产环境中应该很少用到吧
        // 当没有任何消费者使用时，自动删除该队列
        //参数
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = "Hello World!";
//		发送消息到队列中
        for(int i = 0;i<10;i++){
            String tem = message +" "+i;
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, tem.getBytes("UTF-8"));
            System.out.println("P [x] Sent '" + tem + "'");
        }

//		关闭频道和连接
        channel.close();
        connection.close();
    }
}
