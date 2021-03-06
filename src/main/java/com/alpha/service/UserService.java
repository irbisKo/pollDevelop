package com.alpha.service;

import com.alpha.dao.UserDao;
import com.alpha.models.User;

import java.util.List;

public class UserService implements IUserService {

    private static UserDao userDao;


    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(Long id, String... fetchFields) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public User findByEmail(String email) {
        userDao.openCurrentSession();
        User user = userDao.findByEmail(email);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Long id) {
        userDao.openCurrentSessionwithTransaction();
        User book = userDao.findById(id);
        userDao.delete(book);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll(String... fetchFields) {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll(fetchFields);
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }
}
