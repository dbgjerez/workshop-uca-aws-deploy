package com.dbg.workshopucaawsdeploy.service;

import com.dbg.workshopucaawsdeploy.model.Todo;

import java.util.Optional;
import java.util.Set;

public interface TodoService {

    Set<Todo> findAll();

    Optional<Todo> findById(Integer id);

    void delete(Optional<Integer> id);

    Todo create(Todo todo);

}
