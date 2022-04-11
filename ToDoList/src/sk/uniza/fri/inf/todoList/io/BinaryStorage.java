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
public class BinaryStorage implements ITodoStorage {
    private final String fileName;

    public BinaryStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
//      new DummyStorage().load(categories, items);

        try (FileInputStream fis = new FileInputStream(fileName);
             DataInputStream inputStream = new DataInputStream(fis)) {

            int categoryCount = inputStream.readInt();
            for (int i = 0; i < categoryCount; i++) {
                categories.add(new TodoCategory(inputStream.readUTF()));
            }

            int itemsCount = inputStream.readInt();

            for (int i = 0; i < itemsCount; i++) {
                TodoItem item  = new TodoItem();
                item.setTitle(inputStream.readUTF());
                item.setDescription(inputStream.readUTF());
                item.setCreated(inputStream.readLong());
                item.setDone(inputStream.readLong());
                item.setCategory(categories.get(inputStream.readInt()));
                items.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO spracuj vynimku
        }
    }

    @Override
    public void store(ArrayList<TodoCategory> categories, ArrayList<TodoItem> items) {
        try (FileOutputStream fis = new FileOutputStream(fileName);
             DataOutputStream outputStream = new DataOutputStream(fis)) {

            outputStream.writeInt(categories.size());
            for (TodoCategory category : categories) {
                outputStream.writeUTF(category.getName());
            }

            outputStream.writeInt(items.size());
            for (TodoItem item : items) {
                outputStream.writeUTF(item.getTitle());
                outputStream.writeUTF(item.getDescription());
                outputStream.writeLong(item.getCreated());
                outputStream.writeLong(item.getDoneTime());
                outputStream.writeInt(categories.indexOf(item.getCategory()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO spracuj vynimku
        }
    }
}
