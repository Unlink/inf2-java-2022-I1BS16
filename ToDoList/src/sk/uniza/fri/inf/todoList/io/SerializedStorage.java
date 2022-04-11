package sk.uniza.fri.inf.todoList.io;

import sk.uniza.fri.inf.todoList.model.entity.TodoCategory;
import sk.uniza.fri.inf.todoList.model.entity.TodoItem;

import java.io.*;
import java.util.ArrayList;

/**
 * 11. 4. 2022 - 10:23
 *
 * @author Michal
 */
public class SerializedStorage implements ITodoStorage {

    private final String fileName;

    public SerializedStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            ArrayList<TodoCategory> loadedCategories = (ArrayList<TodoCategory>)inputStream.readObject();
            ArrayList<TodoItem> loadedItems = (ArrayList<TodoItem>)inputStream.readObject();
            categories.addAll(loadedCategories);
            items.addAll(loadedItems);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            //TODO spracuj vynimku
        }
    }

    @Override
    public void store(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        try (FileOutputStream fis = new FileOutputStream(fileName);
             ObjectOutputStream outputStream = new ObjectOutputStream(fis)) {
            outputStream.writeObject(categories);
            outputStream.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO spracuj vynimku
        }
    }
}
