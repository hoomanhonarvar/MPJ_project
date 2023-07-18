package com.example.demo.model.rabbitmq;


import com.example.demo.model.message.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    public static final String JSON_ROUTING_KEY= "json_message_exchange";
    public static final String JSONQUEUE="json_queue";
    public static final String EXCHANGE= "message_exchange";

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    public JsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendJsonmessage(MessageDto messageDto){
        LOGGER.info(String.format("json message:%s",messageDto.toString()));
        rabbitTemplate.convertAndSend(EXCHANGE,JSON_ROUTING_KEY,messageDto);
    }
}
