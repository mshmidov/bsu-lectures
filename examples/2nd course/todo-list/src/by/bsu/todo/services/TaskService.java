package by.bsu.todo.services;

import by.bsu.todo.persistence.dao.TaskDao;
import by.bsu.todo.persistence.dao.impl.InMemoryTaskDao;
import by.bsu.todo.persistence.model.Task;

import javax.management.InstanceAlreadyExistsException;
import java.util.*;

/**
 * @author Sergey Krauchenia
 */
public class TaskService {


    private static final Random RANDOM = new Random(10);
    private TaskDao taskDao = InMemoryTaskDao.INSTANCE;

    public Collection<Task> getAll() {
        return taskDao.getAll();
    }

    public Task createNew(String taskTitle) {
        Task task = new Task();
        task.setId(generateRandomId());
        task.setDateCreated(new Date());
        task.setDateModified(new Date());
        task.setTitle(taskTitle);

        try {
            taskDao.save(task);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        }

        return task;
    }

    private static final Long idLimit = 10000000000000L;

    /**
     * can generate 6948973 unique number in the row
     * @return "unique" id
     */
    private Long generateRandomId() {
        return (long)(RANDOM.nextDouble() * idLimit);
    }

    public Task getById(Long taskId) {
        return taskDao.getById(taskId);
    }

    public void update(long taskId, String taskTitle, String description) {
        Task old = getById(taskId);
        old.setTitle(taskTitle);
        old.setDescription(description);
        old.setDateModified(new Date());

        taskDao.update(old);
    }

    public void delete(long taskId) {
        taskDao.delete(taskId);
    }
}
