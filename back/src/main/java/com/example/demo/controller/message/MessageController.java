package com.example.demo.controller.message;


import com.example.demo.model.channel.dto.ChannelDto;
import com.example.demo.model.channel.respone.ResponseChannel;
import com.example.demo.model.message.dto.MessageDto;
import com.example.demo.model.message.request.MessageRequest;
import com.example.demo.model.message.response.MessageResponse;
import com.example.demo.model.rabbitmq.JsonProducer;
import com.example.demo.model.rabbitmq.Producer;
import com.example.demo.model.users.dto.UserDto;
import com.example.demo.service.channel.ChannelService;
import com.example.demo.service.message.MessageService;
import com.example.demo.service.users.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@Tag(name = "Message Controller" ,description = "Message API in message Controller")

@RestController
@RequestMapping("message")//https://localhost:3309/message
public class MessageController
{
    private final MessageService messageService;
    private Producer producer;
    private final UserService userService;

    private final JsonProducer jsonProducer;


    private final ChannelService channelService;
    public MessageController(MessageService messageService , Producer producer, UserService userService, JsonProducer jsonProducer, ChannelService channelService) {
        this.messageService = messageService;
        this.producer=producer;
        this.userService = userService;
        this.jsonProducer = jsonProducer;
        this.channelService = channelService;
    }

//    @GetMapping//localhost:3309/message?sender=   ?receiver= ?message=
//    public ResponseEntity<String>sendMessage(@RequestParam("message") String message,
//                                             @RequestParam("sender") String sender
//                                             ,@RequestParam("receiver") String receiver
//    ){
//        MessageDto messageDto=new MessageDto();
//        messageDto.setBody(message);
//        messageDto.setSender(sender);
//        messageDto.setReceiver(receiver);
//        messageDto.setDate(new Date(System.currentTimeMillis()));
//        producer.sendMessage(messageDto);
//        return ResponseEntity.ok("Message sent to RabbitMQ ...");
//
//
//    }
@Operation(
        summary = "Send Message",
        description = "Sending message in Post methode to  //localhost:8080/message/send URL")

@ApiResponses({
        @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = MessageController.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })

@PostMapping(path="/send",produces={ //localhost:8080/message/send
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<MessageResponse> sendmessage(@RequestBody MessageRequest messageRequest){
        MessageDto messageDto =new ModelMapper().map(messageRequest,MessageDto.class);
        UserDto sender =userService.loadUserByUsername(messageDto.getSender());
        UserDto receiver=userService.loadUserByUsername(messageDto.getReceiver());

        if(sender.getUsername()==null || receiver.getUsername()==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
        messageDto.setDate(new Date(System.currentTimeMillis()));
        messageService.sendmessage(messageDto);
        jsonProducer.sendJsonmessage(messageDto,"message_exchange",messageDto.getReceiver());
        MessageResponse messageResponse=new ModelMapper().map(messageDto, MessageResponse.class);
        messageResponse.setReceived(true);
        ResponseEntity<MessageResponse> messageResponseResponseEntity = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        return messageResponseResponseEntity;}

    }
//    @PostMapping(path="/groupsend",produces={ //localhost:8080/message/channelsend
//            MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE
//    })
//
//    public ResponseEntity<ResponseChannel> sendgroup(@Valid @RequestBody Request)
@Operation(
        summary = "Send Message in Channel",
        description = "Sending message in channel with Post methode to  //localhost:8080/message/channelsend URL")

@ApiResponses({
        @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = MessageController.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }) })

@PostMapping(path = "/channelsend",produces={ //localhost:8080/message/channelsend
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })

    public ResponseEntity<MessageResponse>sendchannelmessage(@Valid @RequestBody MessageRequest messageRequest){
        MessageDto messageDto =new ModelMapper().map(messageRequest,MessageDto.class);
        UserDto sender =userService.loadUserByUsername(messageDto.getSender());
        ChannelDto channelDto=channelService.loadChannelByUsername(messageDto.getReceiver());
        if (sender==null||channelDto==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        if(!sender.getUsername().equals(channelDto.getAdmin())){
            return new ResponseEntity<>(null,HttpStatus.METHOD_NOT_ALLOWED);
        }
        else{
            messageDto.setDate(new Date(System.currentTimeMillis()));
            messageService.sendmessage(messageDto);
            jsonProducer.sendJsonmessage(messageDto,messageDto.getReceiver(),null);
            MessageResponse messageResponse=new ModelMapper().map(messageDto, MessageResponse.class);
            messageResponse.setReceived(true);
            ResponseEntity<MessageResponse> messageResponseResponseEntity = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
            return messageResponseResponseEntity;




        }
    }
//    public ResponseEntity<String> sendJsonMessage(@RequestBody MessageDto messageDto){
//        jsonProducer.sendJsonmessage(messageDto);
//        return ResponseEntity.ok("Json message sent to RabbitMq");
//    }



}
