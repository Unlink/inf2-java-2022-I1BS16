/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.inf.todoList.io;

import sk.uniza.fri.inf.todoList.model.entity.TodoCategory;
import sk.uniza.fri.inf.todoList.model.entity.TodoItem;

import java.util.ArrayList;

/**
 * @author Unlink
 */
public class DummyStorage implements ITodoStorage {

    @Override
    public void load(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        TodoCategory c1 = new TodoCategory("Škola");
        TodoCategory c2 = new TodoCategory("Práca");
        TodoCategory c3 = new TodoCategory("Doma");

        categories.add(c1);
        categories.add(c2);
        categories.add(c3);

        items.add(new TodoItem("Prva todo", "test", c1));
        items.add(new TodoItem("Druha todo", "test", c1));
        items.add(new TodoItem("Tretia todo", "test dscdsc", c1));
        items.add(new TodoItem("Stvrta todo", "test dsfds", c2));
        items.add(new TodoItem("piata todo", "testdsf ", c2));
        items.add(new TodoItem("Siesta todo", "testdsf ds", c3));
        items.add(new TodoItem("Siedma todo", "test dsfds", c1));
    }

    @Override
    public void store(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        //Nope
    }

}
