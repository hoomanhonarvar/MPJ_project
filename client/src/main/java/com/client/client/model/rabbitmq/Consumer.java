package com.client.client.model.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    public static final String QUEUE = "mavi2@gmail.com";
    public static final String ROUTING_KEY = "message_routing_key";

    public static final String EXCHANGE= "message_exchange";

    private static final Logger LOGGER= LoggerFactory.getLogger(Consumer.class);
    @RabbitListener(queues = QUEUE)
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s ",message));

    }
}
