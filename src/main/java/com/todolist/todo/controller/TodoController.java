package com.todolist.todo.controller;

import com.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String home(){
        todoService.
        return "home";
    }

    @GetMapping("/")


}
