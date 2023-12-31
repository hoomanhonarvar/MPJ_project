package com.example.demo.model.message.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MessageResponse  {
    private String sender;
    private String receiver;

    private boolean received;

}
