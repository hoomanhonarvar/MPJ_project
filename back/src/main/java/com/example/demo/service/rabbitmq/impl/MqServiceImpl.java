package com.example.demo.service.rabbitmq.impl;

import com.example.demo.service.rabbitmq.MqService;
import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class MqServiceImpl implements MqService {
   private Queue Queue(String queue){
        return new Queue(queue,true);
    }
//    public static final String EXCHANGE= "message_exchange";
//
    private TopicExchange exchange(String exchange){
        return new TopicExchange(exchange);

    }
    @SneakyThrows
    @Override
    public void new_queue(String username){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);

        Connection connection=factory.newConnection();
        Channel channel = connection.createChannel();
        AMQP.Queue.DeclareOk declareOk=channel.queueDeclare(username,true,false,false,null);
//        Map<String, Object> exchangeArguments = new HashMap<>();
//        exchangeArguments.put("alternate-exchange", "orders-alternate-exchange");
        AMQP.Exchange.DeclareOk declareOk1=channel.exchangeDeclare("message_exchange", BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueBind(username,"message_exchange",username);

        channel.close();
        connection.close();

    }

}
