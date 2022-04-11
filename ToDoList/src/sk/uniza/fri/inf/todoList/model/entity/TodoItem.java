/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.inf.todoList.model.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * @author Unlink
 */
public class TodoItem implements Serializable {

    public static final long serialVersionUID = -5591297454067675398l;

    private String description;
    private long created;
    private long done;
    private String title;
    private TodoCategory category;

    public TodoItem(String title, String description, TodoCategory category) {
        created = Date.from(Instant.now()).getTime();
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public TodoItem() {
        this("Test title", "Popis\npopis2 aaa \nskkkk", null);
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isDone() {
        return done != 0;
    }

    public String getDescription() {
        return description;
    }

    public void unDone() {
        this.done = 0;
    }

    public void done() {
        this.done = Date.from(Instant.now()).getTime();
    }

    public TodoCategory getCategory() {
        return this.category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(TodoCategory category) {
        this.category = category;
    }

    public long getCreated() {
        return created;
    }

    public long getDoneTime() {
        return done;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setDone(long done) {
        this.done = done;
    }

    public boolean test() {
        return true;
    }

}
