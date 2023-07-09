package com.example.demo.user_controller;

import com.example.demo.ui.model.response.UserDetailResponseModel;
import com.example.demo.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("users") //https://localhost:8080/users
public class User_Controller {
    @GetMapping(path="{userId}",
            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
    UserRest returnValue = new UserRest();
    returnValue.setID("hooman");
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
    public ResponseEntity<UserRest> createUser( @RequestBody UserDetailResponseModel userDetails)
    {
        UserRest returnValue = new UserRest();
        returnValue.setID(userDetails.getID());
        returnValue.setPass(userDetails.getPass());
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

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
