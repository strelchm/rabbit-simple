package ru.strelchm.rabbit.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static ru.strelchm.rabbit.simple.Publisher.QUEUE_ROUTING_KEY;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = new DeliverCallback() {
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody());
                System.out.println("Message received: " + message);
            }
        };

        channel.basicConsume(QUEUE_ROUTING_KEY, true, deliverCallback, consumerTag -> {
        });
    }
}
