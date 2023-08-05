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

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        return taskrepo.save(task);
    }

    @GetMapping("/changeStatus")
    public ResponseEntity<Task> changeStatus(@RequestParam Long id)
    {
        Task task = taskrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found :"+id));
        task.setTaskStatus("completed");

        Task updatedtask = taskrepo.save(task);
        return ResponseEntity.ok(updatedtask);

    }

    @GetMapping("/deleteTask")
    public String deleteTaskById(@RequestParam Long id)
    {
        Task task = taskrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found :"+id));
        taskrepo.delete(task);
        return "deleted sucessfully";
    }

	@GetMapping("/alltasks")
    public List<Task> getallTasks()
    {
        return taskrepo.findAll();
    }

    @GetMapping("/getTask")
    public ResponseEntity<Task> getTaskById(@RequestParam Long id)
    {
        Task task = taskrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found :"+id));
        return ResponseEntity.ok(task);
    }	
}
