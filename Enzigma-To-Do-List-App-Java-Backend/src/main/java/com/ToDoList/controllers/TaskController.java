package com.ToDoList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.modal.Task;
import com.ToDoList.modal.TaskStatus;
import com.ToDoList.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask( @RequestBody Task task) throws Exception{
		
		Task createdTask = taskService.createTask(task);
		
		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById( @PathVariable Long id) throws Exception{

		Task task = taskService.getTaskById(id);
		
		return new ResponseEntity<>(task, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getAllTasks")
	public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) TaskStatus status) throws Exception{
		
		List<Task> tasks = taskService.getAllTask(status);
		
		return new ResponseEntity<>(tasks, HttpStatus.FOUND);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable long id,
											@PathVariable Task req) throws Exception{
		
		Task task = taskService.updateTask(id, req);
		
		return new ResponseEntity<>(task, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<Task> completeTask(@PathVariable long id) throws Exception{
		
		Task task = taskService.completeTask(id);
		
		return new ResponseEntity<>(task, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable long id) throws Exception{
		
		taskService.completeTask(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
