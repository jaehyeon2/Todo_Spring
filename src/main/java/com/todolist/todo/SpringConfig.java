package com.todolist.todo;

import com.todolist.todo.repository.TodoRepository;
import org.springframework.context.annotation.Bean;

public class SpringConfig {
    private final TodoRepository todoRepository;


    public SpringConfig(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

//    @Bean
//    public TodoService todoService(){
//        return new TodoService(todoRepository);
//    }
}
