package com.ToDoList.services;

import java.util.List;

import com.ToDoList.modal.Task;
import com.ToDoList.modal.TaskStatus;


public interface TaskService {
	
	Task createTask(Task task) throws Exception;
	
	Task getTaskById(Long id) throws Exception;
	
	List<Task> getAllTask(TaskStatus status);
	
	Task updateTask(Long id, Task updateTask) throws Exception;
	
	void deleteTask(Long id);
	
	Task completeTask(Long taskId) throws Exception;

}
