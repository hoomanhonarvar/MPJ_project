package com.example.demo.ui.model.response;

public class UserRest {
    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    private String Username;
    private String Pass;

    public String getUserId() {
        return Username;
    }

    public String getPass() {
        return Pass;
    }
}
