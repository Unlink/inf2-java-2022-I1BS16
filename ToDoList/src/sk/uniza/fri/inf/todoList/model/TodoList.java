/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.inf.todoList.model;

import sk.uniza.fri.inf.todoList.io.DummyStorage;
import sk.uniza.fri.inf.todoList.io.ITodoStorage;
import sk.uniza.fri.inf.todoList.model.entity.TodoCategory;
import sk.uniza.fri.inf.todoList.model.entity.TodoItem;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Unlink
 */
public class TodoList {

    private ArrayList<TodoCategory> categories;
    private ArrayList<TodoItem> items;
    private ITodoStorage todoStorage;

    public TodoList() {
        //Na uvod budeme mať dummy storage
        this.todoStorage = new DummyStorage();

        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
    }


    public Iterable<TodoCategory> getCategories() {
        return categories;
    }

    public void remove(TodoItem item) {
        items.remove(item);
    }

    public void addTodo(TodoItem item) {
        items.add(item);
    }

    public Stream<TodoItem> getItemsFor(TodoCategory category) {
        return items.stream().filter((t) -> t.getCategory() == category);
    }

    public void loadTodos() {
        categories.clear();
        items.clear();
        this.todoStorage.load(categories, items);
    }

    public void saveTodos() {
        this.todoStorage.store(categories, items);
    }

}
