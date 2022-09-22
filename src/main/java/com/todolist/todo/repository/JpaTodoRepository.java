package com.todolist.todo.repository;

import com.todolist.todo.domain.Todo;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaTodoRepository implements TodoRepository{
    private final EntityManager em;

    public JpaTodoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Todo save(Todo todo){
        em.persist(todo);
        return todo;
    }

    @Override
    public Optional<Todo> findByTodo(String todo) {
        List<Todo> result = em.createQuery("select t from Todo t where t.todo = :todo", Todo. class)
                .setParameter("todo", todo)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Todo> findByStatus(String status) {
        List<Todo> result = em.createQuery("select t from Todo t where t.status = :status", Todo.class)
                .setParameter("status", status)
                .getResultList();
        return result;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
