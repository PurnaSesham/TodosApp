package com.api.todo.app.service;

import com.api.todo.app.model.TodoEntity;
import com.api.todo.app.model.TodoRequest;
import com.api.todo.app.model.TodoResponse;
import com.api.todo.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public TodoResponse createTodo(TodoRequest todoRequest) {

        TodoEntity todoEntity = new TodoEntity();
        TodoResponse todoResponse = new TodoResponse();

        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setDescription(todoRequest.getDescription());

        todoEntity= todoRepository.save(todoEntity);

        todoResponse.setId(todoEntity.getId());
        todoResponse.setTitle(todoEntity.getTitle());
        todoResponse.setDescription(todoEntity.getDescription());

        return todoResponse;
    }
    @Override
   public TodoResponse getTodo(Long id) {

       TodoResponse todoResponse = new TodoResponse();

       TodoEntity todoEntity = todoRepository.getReferenceById(id);

        todoResponse.setId(todoEntity.getId());
        todoResponse.setTitle(todoEntity.getTitle());
        todoResponse.setDescription(todoEntity.getDescription());

        return todoResponse;


    }

    @Override
    public List<TodoResponse> getTodo() {

        List<TodoResponse> todoResponses = new ArrayList<>();

        List<TodoEntity>  todoEntities = todoRepository.findAll();

        for(TodoEntity todoEntity : todoEntities){
            TodoResponse todoResponse = new TodoResponse();

            todoResponse.setId(todoEntity.getId());
            todoResponse.setTitle(todoEntity.getTitle());
            todoResponse.setDescription(todoEntity.getDescription());

            todoResponses.add(todoResponse);
        }
        return todoResponses;
    }

    @Override
    public String deleteTodo(Long id) {
        todoRepository.deleteById(id);
        String str ="Todo Record deleted with "+id;
        return str;
    }

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
        TodoResponse todoResponse = new TodoResponse();
        TodoEntity todoEntity = todoRepository.getReferenceById(id);
        if(todoEntity!=null){
            todoEntity.setTitle(todoRequest.getTitle());
            todoEntity.setDescription(todoRequest.getDescription());
            todoEntity = todoRepository.save(todoEntity);


            todoResponse.setId(todoEntity.getId());
            todoResponse.setTitle(todoEntity.getTitle());
            todoResponse.setDescription(todoEntity.getDescription());

            return todoResponse;
        } else {
            return todoResponse;
        }
    }
}
