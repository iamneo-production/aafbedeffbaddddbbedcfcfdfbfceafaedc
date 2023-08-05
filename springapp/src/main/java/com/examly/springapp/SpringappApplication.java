package com.examly.springapp;

import javax.persistence.*;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringappApplication {

	@PersistenceUnit
	private EntityManagerFactory etmf;

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@PostMapping("/saveTask")
	public void saveTask(@RequestBody Task task) {
		EntityManager etm = etmf.createEntityManager();
		etm.getTransaction().begin();
		etm.persist(task);
		etm.getTransaction().commit();
	}

	@GetMapping("/changeStatus")
	public void changeStatus(@RequestParam("id") String taskId) {
		EntityManager etm = etmf.createEntityManager();
		etm.getTransaction().begin();
		Task task = etm.find(Task.class, taskId);
		task.setTaskStatus("completed");
		etm.getTransaction().commit();
	}

	@GetMapping("/deleteTask")
	public void deleteTask(@RequestParam("id") String taskId) {
		EntityManager etm = etmf.createEntityManager();
		etm.getTransaction().begin();
		Task task = etm.find(Task.class, taskId);
		etm.remove(task);
		etm.getTransaction().commit();
	}

	@GetMapping("/allTasks")
	public List<Task> getAllTasks() {
		EntityManager etm = etmf.createEntityManager();
		Query query = etm.createQuery("SELECT t FROM Task t");
		return query.getResultList();
	}

	@GetMapping("/getTask")
	public Task getTask(@RequestParam("id") String taskId) {
		EntityManager etm = etmf.createEntityManager();
		return etm.find(Task.class, taskId);
	}
}

@Entity
class Task {

	@Id
	private String taskId;
	private String taskHolderName;
	private String taskDate;
	private String taskName;
	private String taskStatus;

	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskHolderName() {
		return taskHolderName;
	}
	public void setTaskHolderName(String taskHolderName) {
		this.taskHolderName = taskHolderName;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
}
