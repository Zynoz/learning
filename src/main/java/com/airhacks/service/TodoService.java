package com.airhacks.service;

import com.airhacks.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext
    EntityManager entityManager;

    public Todo createTodo(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
        return entityManager.merge(todo);
    }

    public Todo findTodo(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
    }

    public Todo deleteTodo(Todo todo) {
        entityManager.remove(todo);
        return todo;
    }

    public Todo deleteTodo(Long id) {
        Todo toDelete = findTodo(id);
        entityManager.remove(toDelete);
        return toDelete;
    }
}