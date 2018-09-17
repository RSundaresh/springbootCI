package com.samples.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.jwtauth.dto.MultipleCount;
import com.samples.jwtauth.dto.UserAndTaskInfo;
import com.samples.jwtauth.jparepository.TaskRepository;
import com.samples.jwtauth.model.Task;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@PostMapping
	public Task addTask(@RequestBody Task task) {
		Task newTask = taskRepository.save(task);
		return newTask;
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@PutMapping("/{id}")
	public void editTask(@PathVariable long id, @RequestBody Task task) {
		Task existingTask = taskRepository.getOne(id);
		Assert.notNull(existingTask, "Task not found");
		existingTask.setDescription(task.getDescription());
		taskRepository.save(existingTask);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable long id) {
		taskRepository.deleteById(id);
	}
	
	@GetMapping("/count")
	public Integer getTaskCount() {
		return taskRepository.getCountOfTasks();
	}
	
	@GetMapping("/counts")
	public List<Object> getTaskCounts() {
		return taskRepository.getMultipleCountOfTasks();
	}
	
	@GetMapping("/usertaskinfo/{userName}")
	public List<UserAndTaskInfo> getUserTaskInfo(@PathVariable("userName") String userName) {
		return taskRepository.getUserTaskInfo(userName);
	}
}
