package com.jjtutti.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jjtutti.taskmanager.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
