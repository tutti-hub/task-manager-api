package com.jjtutti.taskmanager.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jjtutti.taskmanager.dto.TaskResponseDto;
import com.jjtutti.taskmanager.dto.UserResponseDto;
import com.jjtutti.taskmanager.entity.Task;
import com.jjtutti.taskmanager.entity.TaskStatus;
import com.jjtutti.taskmanager.entity.User;
import com.jjtutti.taskmanager.repository.TaskRepository;
import com.jjtutti.taskmanager.repository.UserRepository;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class TaskMapperTest {
    
    @Autowired
    TaskMapper taskMapper;

    @Autowired 
    TaskRepository taskRepository;

    @Autowired 
    UserRepository usedRepository;


    @Test
    public void testTaskMapper() {
        User user = new User("janedoe@mail.com", "Jane Doe");
        user = usedRepository.save(user);

        Task task = new Task("Title", "Description", TaskStatus.TODO, user);
        task = taskRepository.save(task);
        
        TaskResponseDto actualDto = taskMapper.toTaskResponseDto(task);

        assertThat(actualDto.id()).isEqualTo(1);
        assertThat(actualDto.userResponseDto()).isNotNull();
        UserResponseDto userResponseDto = actualDto.userResponseDto();
        assertThat(userResponseDto.id()).isEqualTo(1);

    }
}
