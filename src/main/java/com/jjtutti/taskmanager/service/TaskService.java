package com.jjtutti.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jjtutti.taskmanager.dto.TaskRequestDto;
import com.jjtutti.taskmanager.dto.TaskResponseDto;
import com.jjtutti.taskmanager.entity.Task;
import com.jjtutti.taskmanager.entity.User;
import com.jjtutti.taskmanager.exceptions.TaskNotFoundException;
import com.jjtutti.taskmanager.exceptions.UserNotFoundException;
import com.jjtutti.taskmanager.mapper.TaskMapper;
import com.jjtutti.taskmanager.repository.TaskRepository;
import com.jjtutti.taskmanager.repository.UserRepository;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
    }

    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        User user = userRepository.findById(taskRequestDto.userId())
                        .orElseThrow(() -> new UserNotFoundException(taskRequestDto.userId()));       
        Task task = new Task(taskRequestDto.title(), taskRequestDto.description(), 
                            taskRequestDto.status(), user); 
        task = taskRepository.save(task);
        return taskMapper.toTaskResponseDto(task);
    }

    public List<TaskResponseDto> getAllTasks() {
        var tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toTaskResponseDto).toList();
    }

    public TaskResponseDto getTaskById(Long id) {
        return taskRepository.findById(id)
        .map(taskMapper::toTaskResponseDto)
        .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
