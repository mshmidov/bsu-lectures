package by.bsu.todo.persistence.dao.impl;

import by.bsu.todo.persistence.dao.TaskDao;
import by.bsu.todo.persistence.model.Task;

import javax.management.InstanceAlreadyExistsException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация dao, которая хранит объекты в памяти
 * @author Sergey Krauchenia
 */
public class InMemoryTaskDao implements TaskDao {

    private Map<Long, Task> db = new HashMap<Long, Task>();
    public static final TaskDao INSTANCE = new InMemoryTaskDao();

    private InMemoryTaskDao() {

    }

    @Override
    public Task getById(Long taskId) {
        return db.get(taskId);
    }

    @Override
    public void save(Task task) throws InstanceAlreadyExistsException {
        if (db.containsKey(task.getId())) {
            throw new InstanceAlreadyExistsException(String.format("Task with id %d already exists", task.getId()));
        } else {
            db.put(task.getId(), task);
        }
    }

    @Override
    public void update(Task task) {
        if (!db.containsKey(task.getId())) {
            throw new IllegalArgumentException(String.format("Task with id %d doesn't exists", task.getId()));
        } else {
            db.put(task.getId(), task);
        }
    }

    @Override
    public boolean delete(Long taskId) {
        return db.remove(taskId) != null;
    }

    @Override
    public Collection<Task> getAll() {
        return db.values();
    }
}
