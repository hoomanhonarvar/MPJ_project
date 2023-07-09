package com.example.demo.ui.model.request;

import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class UserDetailRequestModel {
    @Size(min=2, message="Username must be more than 2 character")
    private String UserID;
    @Size(min=8,max=16,message = "password should between 8 and 16 character")
    private String Pass;
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }


}

