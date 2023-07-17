package com.example.demo.user_controller.message;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")//https://localhost:3309/message
public class Controller
{
    @GetMapping
    public String getmessage(){
        return "ana message";

}
    @PostMapping
    public String sendmessage(){
        return "you are message";
    }



}
