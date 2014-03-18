package by.bsu.todo.persistence.dao;

import by.bsu.todo.persistence.model.Task;

import javax.management.InstanceAlreadyExistsException;
import java.util.Collection;
import java.util.List;

/**
 * base interface for task data access object
 * @author Sergey Krauchenia
 */
public interface TaskDao {

    Task getById(Long taskId);

    void save(Task task) throws InstanceAlreadyExistsException;

    void update(Task task);

    boolean delete(Long taskId);

    Collection<Task> getAll();
}
