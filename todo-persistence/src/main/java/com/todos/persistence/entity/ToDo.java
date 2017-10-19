package com.todos.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nokia.exercises.todo.api.TodoStatusValue;

@Entity
public class ToDo {
	@Id
	int todoId;
	String todoName;
	String todoDescription;
	TodoStatusValue todoStatus;

	public TodoStatusValue getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(TodoStatusValue todoStatus) {
		this.todoStatus = todoStatus;
	}

	public int getTodoId() {
		return todoId;
	}
	
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	
	public String getTodoName() {
		return todoName;
	}
	
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	
	public String getTodoDescription() {
		return todoDescription;
	}
	
	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ToDo todo = (ToDo) o;

		if (todoId != todo.todoId) return false;
		return todoName != null ? todoName.equals(todo.todoName) : todo.todoName == null;
	}

	@Override
	public int hashCode() {
		int result = todoId;
		result = 31 * result + (todoName != null ? todoName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoName=" + todoName + ", todoDescription=" + todoDescription
				+ ", todoStatus=" + todoStatus + "]";
	}
}
