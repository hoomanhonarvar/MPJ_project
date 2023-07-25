package com.example.demo.controller.users;

import com.example.demo.controller.channel.ChannelController;
import com.example.demo.model.users.request.UserDetailRequestModel;
import com.example.demo.service.rabbitmq.MqService;
import com.example.demo.service.users.UserService;
import com.example.demo.model.users.dto.UserDto;
import com.example.demo.model.users.response.UserDetailResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
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

//import javax.validation.Valid;


@Tag(name = "User Controller " ,description = "User API in User Controller")

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("users") //https://localhost:8080/users
public class UserController {
    private final UserService userService;

    private final MqService mqService;
    public UserController(UserService userService, MqService mqService) {

        this.userService = userService;
        this.mqService = mqService;
    }


//    @GetMapping
//    public String getUsers(){return "Ana Users!";}
//
//


//    @GetMapping(path="{userId}")
//
//    public UserRest getuser(@PathVariable String userId){
//
//        UserDetails user = userService.loadUserByUsername(userId);
//
//        UserRest userrest= new UserRest();
//        userrest.setPassword(user.getPassword());
//        userrest.setUsername(user.getUsername());
//        return  userrest;
//
//
//    }

//    @PostMapping("/signup")
//
//    public ResponseEntity<UserDetailResponseModel> register() {
//        return register(null);
//    }

    @Operation(
            summary = "Sign in ",
            description = "Sign in to web with Post methode"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ChannelController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })

    @PostMapping(path="/signin", produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
public ResponseEntity<UserDetailResponseModel> signin(@Valid @RequestBody UserDetailRequestModel userRequset ){
    UserDto userDto =userService.loadUserByUsername(userRequset.getUsername());
    String pass= userDto.getPass();

    if(userDto==null){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    else if (!pass.equals(userRequset.getPassword()))
    {
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }
    else  {
        return new ResponseEntity<>(null,HttpStatus.OK);
    }


}

//    public String signin(@Valid @RequestBody UserDetailRequestModel userRequset ){
//        UserDto userDto =userService.loadUserByUsername(userRequset.getUsername());
//        String pass= userDto.getPass();
//
//        if(userDto.getUsername()==null){
//            return("user not found please signup!");
//        }
//
//        else if (!pass.equals(userRequset.getPassword()))
//         {
//             return ("wrong password");
//
//         }
//        else  {
//            return "user signed in without any error";
//        }
//
//
//    }

    @Operation(
            summary = "Signup ",
            description = "Signup to web with Post methode"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ChannelController.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "406", content = { @Content(schema = @Schema()) }) })

    @SneakyThrows
    @PostMapping(path="/signup",            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })

    public ResponseEntity<UserDetailResponseModel> signup(@Valid @RequestBody UserDetailRequestModel userRequest)  {
        UserDto userDto =userService.loadUserByUsername(userRequest.getUsername());
        ObjectMapper objectMapper = new ObjectMapper();
        if(userDto.getUsername()==null) {
            UserDto userDto1 = userService.register(new ModelMapper().map(userRequest, UserDto.class));
//        UserDto userDto = userService.register()
           mqService.new_queue(userDto1.getUsername());
            return new ResponseEntity<>(new ModelMapper().map(userDto1, UserDetailResponseModel.class), HttpStatus.CREATED);
        }
        else{
//            ResponseEntity<UserDetailResponseModel> responseEntity=new ResponseEntity<UserDetailResponseModel>;
            return new  ResponseEntity<> (null,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
