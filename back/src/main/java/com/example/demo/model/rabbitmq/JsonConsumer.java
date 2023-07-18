package com.example.demo.model.rabbitmq;

import com.example.demo.model.message.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    public static final String JSONQUEUE="json_queue";

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonConsumer.class);
    @RabbitListener(queues=JSONQUEUE)
    public void consumeJsonMessage(MessageDto messageDto){
        LOGGER.info(String.format("received json message ->%s",messageDto.toString()));
    }

}
