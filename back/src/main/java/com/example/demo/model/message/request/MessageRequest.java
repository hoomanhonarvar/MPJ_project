package com.example.demo.model.message.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MessageRequest {

    @Email
    private String sender;
    private String receiver;

    @NotBlank
    @NotEmpty
    private String body;

}
