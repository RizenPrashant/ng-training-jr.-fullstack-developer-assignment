package com.ToDoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoList.modal.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
//	public List<Task> findById(long userId);

}
