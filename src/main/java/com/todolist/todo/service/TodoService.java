package com.todolist.todo.service;

import com.todolist.todo.domain.Todo;
import com.todolist.todo.repository.TodoRepository;

import java.util.List;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public String add(Todo todo){
        validateDuplicateTodo(todo);
        todoRepository.save(todo);
        return todo.getTodo();
    }

    private void validateDuplicateTodo(Todo todo){
        todoRepository.findByTodo(todo.getTodo())
                .ifPresent(t->{
                    throw new IllegalStateException("이미 등록한 Todo입니다.");
                });
    }

    public List<Todo> findReadyTodo(){
        return todoRepository.findByS;
    }


}
