package com.kheing.todomanagement;

import com.kheing.todomanagement.entity.Todo;
import com.kheing.todomanagement.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TodoManagementApplication {
	@Autowired
	private TodoService todoService;

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			todoService.addTodo(new Todo(1L,"Todo 1", LocalDate.now(),true));
			todoService.addTodo(new Todo(2L,"Todo 2", LocalDate.now(),false));
			todoService.addTodo(new Todo(3L,"Todo 2", LocalDate.now(),true));
		};
	}
}
