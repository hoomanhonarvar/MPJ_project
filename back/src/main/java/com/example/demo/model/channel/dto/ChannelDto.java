package com.example.demo.model.channel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ChannelDto implements Serializable {

    private long id;
    private String username;
    private String admin;
    private String members[];
    private int numberofmembers;


}
