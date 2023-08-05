package com.examly.springapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.entity.Task;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.exception.ResourceNotFoundException;

@RestController
@RequestMapping("")

public class TaskController {
    @Autowired
	private TaskRepository taskrepo;
	
	@GetMapping("/alltasks")
    public List<Task> getallTasks()
    {
        return taskRepository.findAll();
    }
    
    @PostMapping("/saveTask")
    public Task createTask(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }

    @GetMapping("/getTask")
    public ResponseEntity<Task> getTaskById(@RequestParam Long id)
    {
        Task task = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found :"+id));
        return ResponseEntity.ok(task);
    }

	@GetMapping("/alltasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/getTaskById/{id}")
	public Task getTaskById(@RequestParam String id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping("/getTaskByName/{name}")
	public Task getTaskByTaskHolderName(@RequestParam String taskHolderName) {
		return taskService.getTaskByTaskHolderName(taskHolderName);
	}
	
	
	
	
}
