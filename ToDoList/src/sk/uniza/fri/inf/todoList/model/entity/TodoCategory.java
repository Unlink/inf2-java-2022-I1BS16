/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.inf.todoList.model.entity;

import java.io.Serializable;

/**
 * @author Unlink
 */
public class TodoCategory implements Serializable {

    private final String name;

    public TodoCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}
