package com.example.demo.ui.model.response;

public class UserRest {
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    private String ID;
    private String Pass;

    public String getID() {
        return ID;
    }

    public String getPass() {
        return Pass;
    }
}
