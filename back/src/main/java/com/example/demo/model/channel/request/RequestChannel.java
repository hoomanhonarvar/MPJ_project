package com.example.demo.model.channel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestChannel {
    private String username;
//    @NotEmpty
//    @NotBlank
    private String admin;
    private String members[];
    private int numberofmembers;


}
