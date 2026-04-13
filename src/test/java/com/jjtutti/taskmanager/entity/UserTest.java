package com.jjtutti.taskmanager.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jjtutti.taskmanager.repository.UserRepository;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.util.List;


@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateUser() {
        
        List<User> list = List.of(
            new User("johndoe@mail.com", "John Doe"),
            new User("janeroe@mail.com", "Jane Roe")
        );
        
        list.forEach(userRepository::save);

        var actual = userRepository.findAll();
        
        assertThat(actual.size()).isEqualTo(2);
    }
}
