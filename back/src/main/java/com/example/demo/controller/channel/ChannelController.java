package com.example.demo.controller.channel;


import com.example.demo.model.channel.dto.ChannelDto;
import com.example.demo.model.channel.request.RequestChannel;
import com.example.demo.model.channel.respone.ResponseChannel;
import com.example.demo.service.channel.ChannelService;
import com.example.demo.service.rabbitmq.MqService;
import com.example.demo.service.users.UserService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping(path="/channel", //localhost:8080/channel
                   produces={
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
})
public class ChannelController {
    private final ChannelService channelService;
    private final UserService userService;
    private final MqService mqService;

    public ChannelController(ChannelService channelService, UserService userService, MqService mqService) {
        this.channelService = channelService;
        this.userService = userService;
        this.mqService = mqService;
    }


    @GetMapping
    public String[] getchannel(){


        return channelService.loadChannelByUsername("channel2").getMembers();
    }

    @SneakyThrows

    @PostMapping("create")//localhost:8080/channel/create
    public ResponseEntity<ResponseChannel> createchannel(@Valid @RequestBody RequestChannel requestChannel){
        if(userService.loadUserByUsername(requestChannel.getAdmin())==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        ChannelDto channelDto=channelService.loadChannelByUsername(requestChannel.getUsername());
        if(channelDto.getUsername()==null){
            ChannelDto channelDto1=channelService.register(new ModelMapper().map(requestChannel,ChannelDto.class));
            mqService.new_channel(channelDto1);
            return new ResponseEntity<>(new ModelMapper().map(channelDto1, ResponseChannel.class),HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.MULTIPLE_CHOICES);
        }

    }


}
