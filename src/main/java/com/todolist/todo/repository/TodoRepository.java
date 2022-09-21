package com.todolist.todo.repository;

import com.todolist.todo.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findByTodo(String todo);
    List<Todo> findStatus(String status);
    List<Todo> findAll();
}
