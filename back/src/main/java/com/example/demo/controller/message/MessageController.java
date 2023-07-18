package com.example.demo.controller.message;


import com.example.demo.model.message.dto.MessageDto;
import com.example.demo.model.message.request.MessageRequest;
import com.example.demo.model.message.response.MessageResponse;
import com.example.demo.model.rabbitmq.Producer;
import com.example.demo.service.message.MessageService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")//https://localhost:3309/message
public class MessageController
{
    private final MessageService messageService;
    private Producer producer;
    public MessageController(MessageService messageService ,Producer producer) {
        this.messageService = messageService;
        this.producer=producer;
    }

    @GetMapping//localhost:3309/message?sender=   ?receiver= ?message=
    public ResponseEntity<String>sendMessage(@RequestParam("message") String message,
                                             @RequestParam("sender") String sender
                                             ,@RequestParam("receiver") String receiver
    ){
        MessageDto messageDto=new MessageDto();
        messageDto.setBody(message);
        messageDto.setSender(sender);
        messageDto.setReceiver(receiver);
        producer.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");


    }
    @PostMapping(path="/send",            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<MessageResponse> message(@RequestBody MessageRequest messageRequest){
        MessageDto messageDto =new ModelMapper().map(messageRequest,MessageDto.class);
        messageService.sendmessage(messageDto);
        MessageResponse messageResponse=new ModelMapper().map(messageDto, MessageResponse.class);
        messageResponse.setReceived(true);
        ResponseEntity<MessageResponse> messageResponseResponseEntity = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        return messageResponseResponseEntity;



    }



}
