//package com.example.demo.model.rabbitmq;
//
//
//import com.example.demo.config.rabbitmq.Mqconfig;
//import com.example.demo.model.message.dto.MessageDto;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageListener {
//
//    @RabbitListener(queues = Mqconfig.QUEUE)
//    public void listener(MessageDto messageDto){
//        System.out.println(messageDto);
//    }
//
//}
