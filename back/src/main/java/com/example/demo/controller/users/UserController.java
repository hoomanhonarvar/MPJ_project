package com.example.demo.controller.users;

import com.example.demo.model.users.request.UserDetailRequestModel;
import com.example.demo.service.users.UserService;
import com.example.demo.model.users.dto.UserDto;
import com.example.demo.model.users.response.UserDetailResponseModel;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


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

//    @PostMapping(path="/signin", produces={
//            MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE
//    })
//    public String signin(@Valid @RequestBody UserDetailRequestModel userRequset ){
//        UserDto userDto =userService.loadUserByUsername(userRequset.getUsername());
//        String encpass = passwordEncoder.encode(userRequset.getPassword());
//        boolean m=;
//        if (!m)
//         {
//            throw new UsernameNotFoundException("wrong password");
//        } else {
//            return "user signed in without any error";
//        }
//
//
//    }
    @PostMapping(path="/signup",            produces={
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })

    public ResponseEntity<UserDetailResponseModel> signup(@Valid @RequestBody UserDetailRequestModel userRequest){

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
