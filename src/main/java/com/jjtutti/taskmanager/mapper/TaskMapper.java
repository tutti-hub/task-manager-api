package com.jjtutti.taskmanager.mapper;

import org.springframework.stereotype.Component;

import com.jjtutti.taskmanager.dto.TaskResponseDto;
import com.jjtutti.taskmanager.entity.Task;

@Component
public class TaskMapper {

    private final UserMapper userMapper;

    public TaskMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public TaskResponseDto toTaskResponseDto(Task task) {
        return new TaskResponseDto(task.getId(), 
                                    task.getTitle(), 
                                    task.getDescription(), 
                                    task.getStatus(),
                                    task.getCreatedAt(), 
                                    task.getUpdatedAt(), 
                                    userMapper.toUserResponseDto(task.getUser()));
    }

}
