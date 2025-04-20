package com.api.todo.app.service;

import com.api.todo.app.model.TodoRequest;
import com.api.todo.app.model.TodoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TodoService {
    public TodoResponse createTodo(TodoRequest todoRequest);
    public TodoResponse getTodo(Long id);

    public List<TodoResponse> getTodo();

    public String deleteTodo(Long id);

    public TodoResponse updateTodo(Long id,TodoRequest todoRequest );
}
