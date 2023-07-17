package com.example.demo.model.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private long id;
    private String username;
    private String password;
    private String role;


}
