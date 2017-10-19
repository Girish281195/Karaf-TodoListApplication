package com.nokia.exercises.todo.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.nokia.exercises.todo.api.Todo;
import com.todos.persistence.entity.*;
public class TodoPojoToEntityConverter {
	public static ToDo convertFronPojoToEntity(Todo todo){
		ToDo todoEntity = new ToDo();
		todoEntity.setTodoId(todo.getTodoId());
		todoEntity.setTodoName(todo.getTodoName());
		todoEntity.setTodoStatus(todo.getTodoStatus());
		todoEntity.setTodoDescription(todo.getTodoDescription());
		return todoEntity;
		
	}
	
	public static Todo convertToDoEntityToTodoPojo(ToDo toDo){
		Todo todo = new Todo();
		todo.setTodoId(toDo.getTodoId());
		todo.setTodoName(toDo.getTodoName());
		todo.setTodoDescription(toDo.getTodoDescription());
		todo.setTodoStatus(toDo.getTodoStatus());
		return todo;
	}
	
	
}
