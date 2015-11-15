package com.tcode.controller;

/**
 * Created by Sergey Roshchupkin on 11/13/2015.
 */
public class Message {

    private String type;

    private String message;

    public Message() {
    }

    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

