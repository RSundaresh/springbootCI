package com.samples.jwtauth.dto;

public class UserAndTaskInfo {
	
	private long taskId;
	private String description;
	private long userId;
	private String userName;
	
	
	public UserAndTaskInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAndTaskInfo(long taskId, String description, long userId, String userName) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.userId = userId;
		this.userName = userName;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
