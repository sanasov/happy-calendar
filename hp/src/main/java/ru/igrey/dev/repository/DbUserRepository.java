package ru.igrey.dev.repository;

import ru.igrey.dev.dao.UserDao;
import ru.igrey.dev.domain.User;

public class DbUserRepository implements UserRepository {

    private UserDao userDao;

    public DbUserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByLogin(String login) {
        return userDao.selectByLogin(login);
    }

    @Override
    public User save(User user) {
        if (user == null) {
            userDao.insert(user);
        } else {
            userDao.update(user);
        }
        return user;
    }
}
