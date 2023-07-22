package com.client1.model.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    public static final String QUEUE = "hooman2@gmail.com";


    private static final Logger LOGGER= LoggerFactory.getLogger(Consumer.class);
    @RabbitListener(queues = QUEUE)
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s ",message));

    }
}
