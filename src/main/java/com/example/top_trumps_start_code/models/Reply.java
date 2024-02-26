package com.example.top_trumps_start_code.models;

public class Reply {

    private String message;

    public Reply(){}

    public Reply(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
