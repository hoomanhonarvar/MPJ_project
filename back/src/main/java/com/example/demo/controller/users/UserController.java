package com.example.demo.controller.users;

import com.example.demo.model.users.request.UserDetailRequestModel;
import com.example.demo.service.users.UserService;
import com.example.demo.model.users.dto.UserDto;
import com.example.demo.model.users.response.UserDetailResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("users") //https://localhost:3309/users
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder ;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {

        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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

    @PostMapping(path="/signin", produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public String signin(@Valid @RequestBody UserDetailRequestModel userRequset ){
        UserDto userDto =userService.loadUserByUsername(userRequset.getUsername());
        String pass= userDto.getPass();

        if(userDto.getUsername()==null){
            return("user not found please signup!");
        }

        else if (!pass.equals(userRequset.getPassword()))
         {
             return ("wrong password");

         }
        else  {
            return "user signed in without any error";
        }


    }
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

            return new ResponseEntity<>(new ModelMapper().map(userDto1, UserDetailResponseModel.class), HttpStatus.CREATED);
        }
        else{
//            ResponseEntity<UserDetailResponseModel> responseEntity=new ResponseEntity<UserDetailResponseModel>;
            return new  ResponseEntity<> (null,HttpStatus.MULTIPLE_CHOICES);
        }
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
