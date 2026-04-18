package com.jjtutti.taskmanager.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
