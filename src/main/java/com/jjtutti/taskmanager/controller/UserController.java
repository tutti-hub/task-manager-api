package com.jjtutti.taskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.jjtutti.taskmanager.dto.UserRequestDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
        
    @GetMapping
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
  
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto userDto) {
        return userService.createUser(userDto);
    }
}
