package com.nokia.exercises.todo.impl;

import java.util.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nokia.exercises.todo.api.Todo;
import com.nokia.exercises.todo.api.TodoService;
import com.nokia.exercises.todo.api.TodoStatusValue;
import com.todos.persistence.TodoDBService;
import com.todos.persistence.entity.ToDo;

public class TodoServiceImplementation implements TodoService{
	
	//Map<Integer, Todo> todos = new LinkedHashMap<Integer, Todo>();
	
	private TodoDBService todoDbService;
	public Set<Todo> getTodos() {
		return TodoEntityListToTodoPojoListConverter.convertToDoEntityListToTodoPojoList(todoDbService.getAll());
	}

	public Todo getTodoWithId(Integer todoId) {
		ToDo toDo = todoDbService.getTodo(todoId);
		if(toDo != null){
			return TodoPojoToEntityConverter.convertToDoEntityToTodoPojo(toDo);
		}else{
			return null;
		}
	}
	
	public void addTodo(Todo todo) {
		if(validateTodo(todo)){
			todoDbService.addToDo(TodoPojoToEntityConverter.convertFronPojoToEntity(todo));
		}	
	}

	public boolean removelAllTodos() {
		todoDbService.deleteAllTodos();
		return true;
	}

	public boolean removeTodoWithId(Integer todoId) {
		if(todoDbService.deleteTodo(todoId)){
			return true;
		}else{
			return false;
		}
	}

	public boolean updateTodo(Todo todo) {
		if(todoDbService.updateTodo(TodoPojoToEntityConverter.convertFronPojoToEntity(todo))){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateTodo(Todo todo) {
		if((todo.getTodoId() > 0) && validateTodoStatusValue(todo.getTodoStatus())){
			return true;
		}else{
			return false;
		}
	}
		
	public boolean validateTodoStatusValue(TodoStatusValue todoStatusValue) {
		if(todoStatusValue == TodoStatusValue.Complete || todoStatusValue == TodoStatusValue.InComplete){
			return true;
		}else{
			return false;
		}
	}

	public TodoDBService getTodoDbService() {
		return todoDbService;
	}

	public void setTodoDbService(TodoDBService todoDbService) {
		this.todoDbService = todoDbService;
	}
	
	
}
