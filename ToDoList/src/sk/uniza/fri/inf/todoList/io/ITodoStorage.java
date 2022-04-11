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
public interface ITodoStorage {

    void load(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items);

    void store(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items);

}
