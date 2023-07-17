package com.example.demo.user_controller;

import com.example.demo.model.request.UserDetailRequestModel;
import com.example.demo.service.UserService;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.response.UserDetailResponseModel;
import com.example.demo.model.response.UserRest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


@RestController
@RequestMapping("users") //https://localhost:8080/users
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(){return "Ana Users!";}
//    @GetMapping(path="{userId}",

//    public ResponseEntity<UserRest> getUser(@PathVariable String Username){
//    UserRest returnValue = new UserRest();
//    returnValue.setUsername("hooman");
//    returnValue.setPass("123456789");
//    return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
//
//    }

//    @PostMapping("/signup")
//
//    public ResponseEntity<UserDetailResponseModel> register() {
//        return register(null);
//    }

    @PostMapping(path="/signup",            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })

    public ResponseEntity<UserDetailResponseModel> register(@Valid @RequestBody UserDetailRequestModel userRequest){

        UserDto userDto = userService.register(new ModelMapper().map(userRequest , UserDto.class));
//        UserDto userDto = userService.register()

        return new ResponseEntity<>(new ModelMapper().map(userDto,UserDetailResponseModel.class),HttpStatus.CREATED);
    }
    @PutMapping
    public String changeUser(){
        return "User changeing was called";
    }
    @DeleteMapping
    public String deleteUser(){
        return "User deleting was calles";
    }
}
