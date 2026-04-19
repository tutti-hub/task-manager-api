package com.jjtutti.taskmanager.dto;

import java.time.LocalDateTime;

public record ErrorDto(LocalDateTime timestamp, int status, String message, String path) {
} 

