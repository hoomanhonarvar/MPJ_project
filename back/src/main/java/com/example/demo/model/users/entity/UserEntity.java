package com.example.demo.model.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password; //encrypted pass
    private String pass;
    private String role;



}

