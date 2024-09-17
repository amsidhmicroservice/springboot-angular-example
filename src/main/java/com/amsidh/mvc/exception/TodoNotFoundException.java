package com.amsidh.mvc.exception;

import lombok.Getter;

@Getter
public class TodoNotFoundException extends RuntimeException{

    private final String message;
    public TodoNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
