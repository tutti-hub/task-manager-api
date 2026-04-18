package com.jjtutti.taskmanager.dto;

import java.time.LocalDateTime;

import com.jjtutti.taskmanager.entity.TaskStatus;

public record TaskResponseDto(Long id, 
    String title, 
    String description, 
    TaskStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    UserResponseDto userResponseDto
) {
} 


