package com.kheing.todomanagement.service;

import com.kheing.todomanagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Long> {

    Todo getTodoById(Long id);

}
