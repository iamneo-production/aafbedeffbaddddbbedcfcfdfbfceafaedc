package com.examly.springapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.entity.Task;
import com.examly.springapp.service.TaskService;

@RestController
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
	
    @DeleteMapping("/deleteTask/{id}")
	public void deleteTask(@RequestParam String id) {
		taskService.deleteTask(id);
	}
	
	@GetMapping("/alltasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/getTask/{id}")
	public Task getTaskById(@RequestParam String id) {
		return taskService.getTaskById(id);
	}
	
	
		
}
