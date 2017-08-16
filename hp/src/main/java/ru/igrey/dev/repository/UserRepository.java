package ru.igrey.dev.repository;

import ru.igrey.dev.domain.User;

public interface UserRepository {

    User findByLogin(String login);
    User save(User user);
}
