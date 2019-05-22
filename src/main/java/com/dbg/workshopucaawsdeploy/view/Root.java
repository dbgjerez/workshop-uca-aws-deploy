package com.dbg.workshopucaawsdeploy.view;

import com.dbg.workshopucaawsdeploy.model.Todo;
import com.dbg.workshopucaawsdeploy.service.TodoService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Route("todo")
public class Root extends VerticalLayout {

    public static final String TEXT_ADD_TODO = "Añadir";
    public static final String TEXT_DELETE_TODO = "Eliminar";
    final HorizontalLayout main = new HorizontalLayout();
    final Button btnAdd = new Button(TEXT_ADD_TODO);
    final Button btnDelete = new Button(TEXT_DELETE_TODO);
    final Grid<Todo> todos = new Grid<>();

    @Autowired
    TodoService todoService;

    public Root() {
        todos.addColumn(Todo::getTxt).setHeader("Tarea");
        todos.addColumn(Todo::getDone).setHeader("Terminada");
        btnAdd.addClickListener(l -> {
            createRandom();
            updateElements();
        });
        btnDelete.addClickListener(l -> {
            todoService.delete(todoService.findAll().stream().findAny().map(Todo::getIdTodo));
            updateElements();
        });
        add(todos, new HorizontalLayout(btnAdd, btnDelete));
    }

    public void createRandom() {
        final Todo todo = new Todo();
        todo.setTxt(RandomStringUtils.randomAlphabetic(12));
        todo.setDone(Math.random() < 0.5);
        todoService.create(todo);
    }

    public synchronized void updateElements() {
        todos.setItems(todoService.findAll());
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        updateElements();
    }
}
