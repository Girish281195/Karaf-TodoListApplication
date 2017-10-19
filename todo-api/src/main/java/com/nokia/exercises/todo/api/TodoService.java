package com.nokia.exercises.todo.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;

public interface TodoService {
	
	public Set<Todo> getTodos();

    public Todo getTodoWithId(Integer todoId);

	public void addTodo(Todo todo);

	public boolean removelAllTodos();

	public boolean removeTodoWithId(Integer todoId);

	public boolean updateTodo(Todo todo);
	
	///  todos/1/status
	//public boolean updateTodoStatus(Integer todoId, Todo todo);
}
