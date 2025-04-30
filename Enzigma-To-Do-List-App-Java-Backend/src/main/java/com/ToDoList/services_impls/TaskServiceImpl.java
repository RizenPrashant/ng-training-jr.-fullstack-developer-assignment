package com.ToDoList.services_impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDoList.modal.Task;
import com.ToDoList.modal.TaskStatus;
import com.ToDoList.repositories.TaskRepository;
import com.ToDoList.services.TaskService;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createTask(Task task) throws Exception {
		task.setStatus(TaskStatus.NOT_STARTED);
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) throws Exception {
		return taskRepository.findById(id).orElseThrow(() -> new Exception("no task found with id" + id));
	}

	@Override
	public List<Task> getAllTask(TaskStatus status) {
		List<Task> allTask = taskRepository.findAll();
		return allTask;
	}

	@Override
	public Task updateTask(Long id, Task updateTask) throws Exception {

		Task existingTask = getTaskById(id);
		if (updateTask.getTitle() != null) {
			existingTask.setTitle(updateTask.getTitle());
		}
		if (updateTask.getPriority() != null) {
			existingTask.setPriority(updateTask.getPriority());
		}
		if (updateTask.getComments() != null) {
			existingTask.setComments(updateTask.getComments());
		}
		if (updateTask.getStatus() != null) {
			existingTask.setStatus(updateTask.getStatus());
		}
		if (updateTask.getDueDate() != null) {
			existingTask.setDueDate(updateTask.getDueDate());
		}
		return taskRepository.save(existingTask);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task completeTask(Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setStatus(TaskStatus.COMPLETED);
		return taskRepository.save(task);
	}

}
