package edu.security.service.impl;

import edu.security.dao.DAO;
import edu.security.dao.in_memory_impl.UserDAO;
import edu.security.entity.User;
import edu.security.service.UserService;

import java.util.Collection;


public class UserServiceImpl implements UserService {
    private static DAO<Long, User> userDao = UserDAO.getInstance();

    @Override
    public Collection<User> getAllUsers() {
        return userDao.getAll();
    }
}
