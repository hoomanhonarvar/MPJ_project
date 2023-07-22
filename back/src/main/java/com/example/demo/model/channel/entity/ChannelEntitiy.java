package com.example.demo.model.channel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChannelEntitiy {
    private long id ;
    private String Admin;
    private String members[];

}
