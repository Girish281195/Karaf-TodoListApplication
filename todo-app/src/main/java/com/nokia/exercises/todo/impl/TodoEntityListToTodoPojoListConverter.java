package com.nokia.exercises.todo.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.nokia.exercises.todo.api.Todo;
import com.todos.persistence.entity.ToDo;

public class TodoEntityListToTodoPojoListConverter {
	public static Set<Todo> convertToDoEntityListToTodoPojoList(List<ToDo> todoList){
		Set<Todo> setOfTodos = new LinkedHashSet<Todo>();
		for(ToDo toDo : todoList){
			setOfTodos.add(TodoPojoToEntityConverter.convertToDoEntityToTodoPojo(toDo));
		}
		return setOfTodos;
	}
}
