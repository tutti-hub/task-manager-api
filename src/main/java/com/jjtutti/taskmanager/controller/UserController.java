package com.jjtutti.taskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjtutti.taskmanager.dto.UserRequestDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.service.UserService;

import java.util.List;

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
    public List<UserResponseDto> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getMethodName(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
  
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        System.out.println("controller insert ****************");
        System.out.println(userDto);
        System.out.println("controller insert ****************");
        return userService.createUser(userDto);
    }

}
