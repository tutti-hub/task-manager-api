package com.jjtutti.taskmanager.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.jjtutti.taskmanager.dto.TaskRequestDto;
import com.jjtutti.taskmanager.dto.TaskResponseDto;
import com.jjtutti.taskmanager.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)    
    public TaskResponseDto createTask(@RequestBody @Valid TaskRequestDto taskRequestDto) {
        return taskService.createTask(taskRequestDto);
    }

    @GetMapping
    public Page<TaskResponseDto> getAllTasks(Pageable pageable) {
        return taskService.getAllTasks(pageable);
    }

    @GetMapping("/{id}")
    public TaskResponseDto getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
}
