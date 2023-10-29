package org.senai.devin.crudapi.database;

import org.senai.devin.crudapi.exceptions.NotFoundException;
import org.senai.devin.crudapi.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Integer nextId = 0;
    private static List<Task> tasks = new ArrayList<>();

    public static void add(Task task) {
        Database.tasks.add(task);
    }

    public static void remove(Integer id) {
        Database.tasks.removeIf(task -> task.getId().equals(id));
    }

    public static List<Task> listAll() {
        return Database.tasks;
    }

    public static Task get(Integer id) throws NotFoundException {
        return Database.tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("A tarefa não foi encontrada"));
    }

    public static Integer setId() {
        Database.nextId = Database.nextId + 1;
        return Database.nextId;
    }
}
