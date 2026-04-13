package com.jjtutti.taskmanager.dto;

import java.time.LocalDate;

public record UserResponseDto (Long id, String email, String name, LocalDate createdOn) {

}
