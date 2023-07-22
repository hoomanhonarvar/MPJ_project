package com.example.demo.model.channel.respone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseChannel {
    private String username;
    private String admin;
    private String members[];
    private int numberofmembers;

}
