package com.examly.springapp;

import javax.swing.text.html.parser.Entity;
import javax.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringappApplication {

	@PersistenceUnit
	private EntityManagerFactory etmf;

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@PostMapping("/saveTask")
	public void saveTask(@RequestBody Task task) {
		EntityManager etm = etmf.createEntityManager();
		etm.getTransaction.begin();
		etm.persist(task);
		etm.getTransaction.commit();
	}

}

@Entity
public class Task {

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
