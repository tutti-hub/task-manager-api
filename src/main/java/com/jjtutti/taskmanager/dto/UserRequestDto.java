package com.jjtutti.taskmanager.dto;

import java.time.LocalDate;

public record UserRequestDto(String email, String name, LocalDate createdOn) {

}
