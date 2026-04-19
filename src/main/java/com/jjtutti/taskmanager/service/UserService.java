package com.jjtutti.taskmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.jjtutti.taskmanager.dto.UserRequestDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.exceptions.UserNotFoundException;
import com.jjtutti.taskmanager.mapper.UserMapper;
import com.jjtutti.taskmanager.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserRequestDto userDto) {
        var newUser  = userRepository.save(userMapper.fromUserRequestDto(userDto));
        return userMapper.toUserResponseDto(newUser);
    }
    
    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
         return userRepository.findAll(pageable).map(userMapper::toUserResponseDto);
    }

    public UserResponseDto getUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)); 
        return userMapper.toUserResponseDto(user);         
    }    
}
