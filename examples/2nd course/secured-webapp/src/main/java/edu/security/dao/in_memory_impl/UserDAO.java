package edu.security.dao.in_memory_impl;

import edu.security.dao.DAO;
import edu.security.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDAO implements DAO<Long, User> {
    private static final UserDAO USER_DAO = new UserDAO();

    private UserDAO() {}

    public static UserDAO getInstance() {
        return USER_DAO;
    }

    private static Map<Long, User> userMap = new HashMap<Long, User>();

    private static long counter = 0;


    static {
        for (int i = 0; i < 10; i++) {
            USER_DAO.save(new User("email" + i + "@email.com", "pass" + i, "FName" + i, "LName" + i));
        }
    }

    @Override
    public Collection<User> getAll() {
        return userMap.values();
    }

    @Override
    public User get(Long id) {
        return userMap.get(id);
    }

    @Override
    public void save(User entity) {
        Long id = entity.getId();
        if (id == null) {
            counter++;
            entity.setId(counter);
        }
        userMap.put(entity.getId(), entity);
    }

    @Override
    public void delete(Long id) {
        userMap.remove(id);
    }
}
