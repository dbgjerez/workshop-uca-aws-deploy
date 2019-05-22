package com.dbg.workshopucaawsdeploy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Integer idTodo;

    @Column(nullable = false)
    private String txt;

    private Boolean done = Boolean.FALSE;

}
