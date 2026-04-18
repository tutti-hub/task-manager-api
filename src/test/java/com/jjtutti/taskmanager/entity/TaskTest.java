package com.jjtutti.taskmanager.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jjtutti.taskmanager.repository.TaskRepository;
import com.jjtutti.taskmanager.repository.UserRepository;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class TaskTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TaskRepository taskRepository; 


    @Test
    public void testCreateTask() {
        User user = new User("janedoe@mail.com", "Jane Doe");
        user = userRepository.save(user);
        
        Task task = new Task("Title", "Description", TaskStatus.TODO, user);
        var actual = taskRepository.save(task);
        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getUser()).isNotNull();
        assertThat(actual.getUser().getId()).isEqualTo(1);
    }

}
