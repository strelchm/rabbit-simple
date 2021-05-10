package ru.strelchm.rabbit.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

    public static final String QUEUE_ROUTING_KEY = "Queue-1";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        String message = "Hello,world! My name is Michael!";

        Channel channel = connection.createChannel();
        channel.basicPublish("", QUEUE_ROUTING_KEY, null, message.getBytes());

        channel.close();
        connection.close();
    }

}
