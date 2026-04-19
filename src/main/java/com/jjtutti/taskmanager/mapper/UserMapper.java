package com.jjtutti.taskmanager.mapper;

import org.springframework.stereotype.Component;
import com.jjtutti.taskmanager.dto.UserRequestDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.entity.User;

@Component
public class UserMapper {

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName(), user.getCreatedOn());
    }

    public User fromUserRequestDto(UserRequestDto userDto) {
        return new User(userDto.email(), userDto.name());
    }
}
