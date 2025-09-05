package com.api.todo.app.controller;

import com.api.todo.app.model.TodoRequest;
import com.api.todo.app.model.TodoResponse;
import com.api.todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/v1")
public class TodoController {

    @Autowired
    TodoService todoService;

    //tesing

    //http://localhost:8081/api/todo/v1/addTodo

    @PostMapping("/addTodo")
    public TodoResponse createTodo(@RequestBody TodoRequest todoRequest){
        return todoService.createTodo(todoRequest);
    }

    //http://localhost:8081/api/todo/v1/getTodo/1

    @GetMapping("/getTodo/{id}")
    public TodoResponse getTodo(@PathVariable Long id) {
     return todoService.getTodo(id);
    }

    //http://localhost:8081/api/todo/v1/getAllTodo

    @GetMapping("/getAllTodo")
    public List<TodoResponse> getTodo() {
        return todoService.getTodo();
    }

    //http://localhost:8081/api/todo/v1/updateTodo/1

    @PutMapping("/updateTodo/{id}")
    public TodoResponse updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest){
       return todoService.updateTodo(id,todoRequest);
    }

    //http://localhost:8081/api/todo/v1/deleteTodo/1

   @DeleteMapping("/deleteTodo/{id}")
   public String removeTodo(@PathVariable Long id){
      return todoService.deleteTodo(id);
   }
}
