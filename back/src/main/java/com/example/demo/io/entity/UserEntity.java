package com.example.demo.io.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "users")
public class UserEntity implements Serializable{
    private static final long serialVersionUID =5313493413859894403L;

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEncryptedPass() {
        return encryptedPass;
    }

    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }

    @Column(nullable = false)
    private String Username;


    @Column(nullable = false ,length = 50)
    private String Pass;

    @Column(nullable = false)
    private String encryptedPass;
}

