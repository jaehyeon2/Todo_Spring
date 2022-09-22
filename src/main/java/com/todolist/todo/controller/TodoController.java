package com.todolist.todo.controller;

import com.todolist.todo.domain.Todo;
import com.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Todo> readyTodo = todoService.findReadyTodo();
        List<Todo> progressTodo = todoService.findProgressTodo();
        List<Todo> finishTodo = todoService.findFinishTodo();

        model.addAttribute("readyTodo", readyTodo);
        model.addAttribute("progressTodo", progressTodo);
        model.addAttribute("finishTodo", finishTodo);

        return "home";
    }

//    @GetMapping("/")


}
