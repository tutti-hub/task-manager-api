package com.jjtutti.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jjtutti.taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
