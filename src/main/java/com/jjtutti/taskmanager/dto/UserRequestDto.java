package com.jjtutti.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(@NotBlank @Email String email, @NotBlank String name) {

}
