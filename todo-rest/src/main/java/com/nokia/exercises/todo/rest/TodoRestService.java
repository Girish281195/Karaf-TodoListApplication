package com.nokia.exercises.todo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nokia.exercises.todo.api.Todo;

@Path("todos")
public interface TodoRestService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Todo> handleGet();
	
	@GET
    @Path("{todoId}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response handleGetWithTodoId(@PathParam("todoId") Integer todoId);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response handlePost(Todo[] todoList);
	
	@DELETE
	public Response handleDelete();
	
	@DELETE
	@Path("{todoId}")
	public Response handleDeleteWithTodoId(@PathParam("todoId") Integer todoId);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response handlePut(Todo todo);
	
	///  todos/1/status
	/*@PUT
	@Path("{todoId}/status")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response handlePutToUpdateStatus(@PathParam("todoId") Integer todoId, Todo todo);*/
}
