package com.example.demo.model.channel.respone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseChannel {

    private String Admin;
    private String members[];
}
