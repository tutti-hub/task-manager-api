package com.jjtutti.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jjtutti.taskmanager.dto.UserRequestDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.entity.User;
import com.jjtutti.taskmanager.mapper.UserMapper;
import com.jjtutti.taskmanager.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public UserResponseDto createUser(UserRequestDto userDto) {
        var newUser  = userRepository.save(userMapper.fromUserRequestDto(userDto));
        return userMapper.toUserResponseDto(newUser);
    }
    
    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserResponseDto).toList();
    }

    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toUserResponseDto).orElse(null);         
    }    

}
