package com.example.demo.model.channel.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestChannel {

    private String Admin;
    private String members[];

}
