package com.dbg.workshopucaawsdeploy.service;

import com.dbg.workshopucaawsdeploy.dao.TodoRepository;
import com.dbg.workshopucaawsdeploy.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Set<Todo> findAll() {
        return todoRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return todoRepository.findById(id);
    }

    @Override
    public void delete(Optional<Integer> id) {
        id.ifPresent(todoRepository::deleteById);
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }
}
