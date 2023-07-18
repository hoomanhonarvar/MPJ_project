package com.example.demo.model.rabbitmq;

import com.example.demo.config.rabbitmq.Mqconfig;
import com.example.demo.model.message.dto.MessageDto;
import com.example.demo.service.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController

public class Producer {
    public static final String QUEUE = "message_queue";
    public static final String ROUTING_KEY = "message_routing_key";

    public static final String EXCHANGE= "message_exchange";

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private MessageService messageService;
    private RabbitTemplate rabbitTemplate;
    public Producer(RabbitTemplate rabbitTemplate,MessageService messageService){
        this.rabbitTemplate=rabbitTemplate;
        this.messageService=messageService;
    }


    public void sendMessage(MessageDto messageDto){
        LOGGER.info(String.format("Message %s from %s --> %s",messageDto.getBody(),messageDto.getSender(),messageDto.getReceiver()));
        messageService.sendmessage(messageDto);
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,messageDto.toString());




    }
}
