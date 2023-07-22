package com.example.demo.model.channel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ChannelDto {

    private long id;
    private String Admin;
    private String members[];


}
