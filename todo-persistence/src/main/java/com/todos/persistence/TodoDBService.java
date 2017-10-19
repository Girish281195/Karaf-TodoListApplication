package com.todos.persistence;

import java.util.List;
import com.todos.persistence.entity.*;

public interface TodoDBService {
	public boolean addToDo(ToDo todo);
	public List<ToDo> getAll();
	public boolean updateTodo(ToDo todo);
	public ToDo getTodo(int todoId);
	public boolean deleteTodo(int todoId);
	public void deleteAllTodos();
}
