package com.examly.springapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.entity.Task;
import com.examly.springapp.service.TaskService;


public class TaskController {
    @Autowired
	private TaskService taskService;
	
	@PostMapping("/saveTask")
	public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

    @GetMapping("/changeStatus")
	public Task changeStatus(@RequestParam String id) {
		return taskService.changeStatus(id);
	}
	
    @GetMapping("/deleteTask/{id}")
	public void deleteTask(@RequestParam String id) {
		taskService.deleteTask(id);
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
