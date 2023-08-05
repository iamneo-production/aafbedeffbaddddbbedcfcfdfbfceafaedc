package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.entity.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService {
    
	private final TaskRepository taskRepo;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
//	public List<Task> getAllTasks()
//	{
//		List<Task> tasks = new ArrayList<>();
//		taskRepo.findAll().forEach(tasks::add);
//		return tasks;
//	}

	public void addTask(Task task) {
		taskRepo.save(task);
		
	}

	public Task changeStatus(String id) {
		Task t=taskRepo.findByTaskId(id);
		Task t1=taskRepo.findById(t.getId()).orElse(null);

		t1.setTaskStatus("completed");
		return taskRepo.save(t);
	}

	public void deleteTask(String id) {
		Task t=taskRepo.findByTaskId(id);
		Task t1=taskRepo.findById(t.getId()).orElse(null);
		taskRepo.deleteById(t1.getId());
	}
	public Task getTaskById(String id) {
		Task t=taskRepo.findByTaskId(id);
		return taskRepo.findById(t.getId()).orElse(null);
	}
	public Task saveTask(Task task) {
		return taskRepo.save(task);
	}
	public List<Task> getAllTasks(){
		return taskRepo.findAll();
	}
}
