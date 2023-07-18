package com.example.demo.model.message.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageDto {
    private long id;
    private String sender;
    private String receiver;
    private String body;
    private Date date;

}
