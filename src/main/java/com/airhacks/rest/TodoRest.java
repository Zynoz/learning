package com.airhacks.rest;

import com.airhacks.entity.Todo;
import com.airhacks.service.TodoService;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {
    private final Logger LOGGER = Logger.getLogger(TodoRest.class.getName());

    @Inject
    TodoService todoService;

    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTodo(Todo todo) {
        Response.ResponseBuilder builder;
        try {
            todoService.createTodo(todo);
            builder = Response.ok();
            LOGGER.info("created: " + todo.toString());
        } catch (ValidationException e) {
            String errorMsg = "ERROR: " + e.getMessage();
            builder = Response.status(409).entity(errorMsg);
            LOGGER.severe("error:");
        }
        return builder.build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        LOGGER.info("updated: " + todoService.updateTodo(todo).toString());
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        Todo todo = todoService.findTodo(id);
        LOGGER.info("todo: " + todo + " with id: " + id);
        return todoService.findTodo(id);
    }

    @Path("list")
    @GET
    public List<Todo> getTodos() {
        List<Todo> todos = todoService.getTodos();
        LOGGER.info(todos.toString());
        return todos;
    }

    @Path("delete/{id}")
    @POST
    public Todo deleteTodo(@PathParam("id")Long id) {
        return todoService.deleteTodo(id);
    }

    @Path("delete")
    @POST
    public Todo deleteTodo(Todo todo) {
        return todoService.deleteTodo(todo);
    }
}
