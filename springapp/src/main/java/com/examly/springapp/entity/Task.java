package com.examly.springapp.entity;

import javax.persistence.*;

@Entity
@Table(name="mytasks")
public class Task {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "taskId")
	private String taskId;
	@Column(name = "taskHolderName")
	private String taskHolderName;
	@Column(name = "taskDate")
	private String taskDate;
	@Column(name = "taskName")
	private String taskName;
	@Column(name = "taskStatus")
	private String taskStatus;
	
	
	public Task() {
	}
	
	public Task(String taskId, String taskHolderName, String taskDate, String taskName, String taskStatus) {
		super();
		this.taskId = taskId;
		this.taskHolderName = taskHolderName;
		this.taskDate = taskDate;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
	}
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