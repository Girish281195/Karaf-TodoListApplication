package com.todos.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.todos.persistence.entity.ToDo;

@Transactional
public class TodoDBServiceImpl implements TodoDBService{
	
	@PersistenceUnit(unitName="Todo")
	private EntityManagerFactory entityManagerFactory;
	public boolean addToDo(ToDo todo) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.persist(todo);
		em.flush();
		return true;
	}

	public List<ToDo> getAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM ToDo;", ToDo.class);
	    ArrayList<ToDo> todoList = (ArrayList<ToDo>) query.getResultList();
		return todoList;
	}

	public boolean updateTodo(ToDo todo) {
		EntityManager em = entityManagerFactory.createEntityManager();
		ToDo toDo = em.find(ToDo.class, todo.getTodoId());
		if(toDo != null){
			toDo.setTodoName(todo.getTodoName());
			toDo.setTodoDescription(todo.getTodoDescription());
			toDo.setTodoStatus(todo.getTodoStatus());
			return true;
		}
		return false;
	}

	public ToDo getTodo(int todoId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		ToDo toDo = em.find(ToDo.class, todoId);
		if(toDo != null){
			return toDo;
		}
		return null;
	}

	public boolean deleteTodo(int todoId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		ToDo toDo = em.find(ToDo.class, todoId);
		if(toDo != null){
            em.remove(toDo);
            return true;
        }
		return false;
	}

	public void deleteAllTodos() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createNativeQuery("DELETE FROM ToDo");
		query.executeUpdate();
		
	}


}
