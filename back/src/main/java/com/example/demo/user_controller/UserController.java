package com.example.demo.user_controller;

import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.model.response.UserDetailResponseModel;
import com.example.demo.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("users") //https://localhost:8080/users
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="{userId}",
            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String Username){
    UserRest returnValue = new UserRest();
    returnValue.setUsername("hooman");
    returnValue.setPass("123456789");
    return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

    }

    @PostMapping(
            consumes ={
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE}
    ,produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }
    )
    public UserRest createUser( @RequestBody UserDetailResponseModel userDetails)
    {
        UserRest returnValue = new UserRest();
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        UserDto createUser= userService.createUser(userDto);
        BeanUtils.copyProperties(createUser,returnValue);
//        returnValue.setUsername( userDetails.getUsername());
//        returnValue.setPass(userDetails.getPass());
//        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
            return returnValue;
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
