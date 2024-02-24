package com.kheing.todomanagement.controller;

import com.kheing.todomanagement.entity.Todo;
import com.kheing.todomanagement.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GeneralController {

    private TodoService todoService;

    @Autowired
    public GeneralController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public String retrieveAllTodos(Model model) {

        List<Todo> allTodos = todoService.getAllTodos();
        model.addAttribute("todos", allTodos);
        return "todos";
    }

    @GetMapping("/add-todo")
    public String showTodoDetail(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit-todo/{id}")
    public String showTodoDetail(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo-edit";
    }

    @PostMapping("/edit-todo/{id}")
    public String showTodoDetail(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete-todo/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }

}
