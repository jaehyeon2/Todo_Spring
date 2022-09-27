package com.todolist.todo.controller;

import com.todolist.todo.domain.Todo;
import com.todolist.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/todo")
    public String addTodo(TodoForm form){
        Todo todo = new Todo();
        todo.setTodo(form.getTodo());
        todo.setStatus("ready");
        todoService.add(todo);

        return "redirect:/";
    }

    @PostMapping("/edit/:id")
    public String editTodoStatus(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        Optional<Todo> todo = todoService.findById(id);
        String status = todo.get().getStatus();
        if(status == "ready"){
            status = "progress";
        } else if(status == "progress"){
            status = "finish";
        } else{
            status = "end";
        }
        
        //status query 추가

        return "redirect:/";
    }
//    @GetMapping("/")


}
