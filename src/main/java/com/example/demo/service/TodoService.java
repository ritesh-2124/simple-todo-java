package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // CREATE
    public Todo createTodo(String title) {
        Todo todo = new Todo(title);
        return todoRepository.save(todo);
    }

    // READ
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // UPDATE
    public Todo markCompleted(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(true);
        return todoRepository.save(todo);
    }

    // DELETE
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
