package com.example.demo.service.message.impl;

import com.example.demo.Repository.message.MessageRepository;
import com.example.demo.model.message.dto.MessageDto;
import com.example.demo.model.message.entity.MessageEntity;
import com.example.demo.service.message.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService
{
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public MessageDto sendmessage(MessageDto messageDto){
        MessageEntity messageEntity=new MessageEntity();
        messageEntity.setBody(messageDto.getBody());
        messageEntity.setSender(messageDto.getSender());
        messageEntity.setReceiver(messageDto.getReceiver());
        MessageEntity savedMessageEntity= messageRepository.save(messageEntity);
        return new ModelMapper().map(savedMessageEntity,MessageDto.class);
    }



}
