package com.example.demo.controller.channel;


import com.example.demo.model.channel.dto.ChannelDto;
import com.example.demo.model.channel.request.RequestChannel;
import com.example.demo.model.channel.respone.ResponseChannel;
import com.example.demo.service.channel.ChannelService;
import com.example.demo.service.rabbitmq.MqService;
import com.example.demo.service.users.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Channel Controller" ,description = "Channel API in messanger")
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

    @Operation(
            summary = "getting informations of MPJ_channel_new ",
            description = "getting informations of MPJ_channel_new"
            )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ChannelController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
    @GetMapping
    public String[] getchannel(){


        return channelService.loadChannelByUsername("MPJ_channel_new").getMembers();
    }

    @SneakyThrows


    @Operation(
            summary = "create channel",
            description = "creating new channel with POST methode to localhost:8080/channel/create"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ChannelController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "406", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

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
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }


}
