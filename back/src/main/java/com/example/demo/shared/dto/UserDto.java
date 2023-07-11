package com.example.demo.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String Username;

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

    private String Pass;
    private String encryptedPass;

}
