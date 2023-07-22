package com.example.demo.controller.channel;


import com.example.demo.model.channel.entity.ChannelEntitiy;
import com.example.demo.model.channel.request.RequestChannel;
import com.example.demo.model.channel.respone.ResponseChannel;
import jakarta.validation.Valid;
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


    @GetMapping
    public String getchannel(){
        return "this is channel";
    }

    @PostMapping("create")//localhost:8080/channel/create
    public ResponseEntity<ResponseChannel> createchannel(@Valid @RequestBody RequestChannel requestChannel){


    }


}
