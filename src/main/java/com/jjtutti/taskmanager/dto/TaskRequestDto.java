package com.jjtutti.taskmanager.dto;

import com.jjtutti.taskmanager.entity.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDto(@NotBlank String title, 
    String description, 
    @NotNull TaskStatus status,
    @NotNull Long userId) {

    public TaskRequestDto(String title, TaskStatus status, Long userId) {
        this(title, null, status, userId);
    }    
}
