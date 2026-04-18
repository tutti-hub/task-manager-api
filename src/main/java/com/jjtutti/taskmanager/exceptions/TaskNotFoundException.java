package com.jjtutti.taskmanager.exceptions;

public class TaskNotFoundException extends RuntimeException {
    
    public TaskNotFoundException() {
        super("Task not found"); 
    }

    public TaskNotFoundException(String msg) {
        super(msg);
    }

    public TaskNotFoundException(Long id) {
        super("Task with id " + id + " not found");
    }
}
