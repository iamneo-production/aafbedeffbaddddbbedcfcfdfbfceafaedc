package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task findByTaskId(String taskId);   
}
