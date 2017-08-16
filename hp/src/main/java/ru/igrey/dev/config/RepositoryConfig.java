package ru.igrey.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.igrey.dev.dao.UserDao;
import ru.igrey.dev.repository.DbUserRepository;
import ru.igrey.dev.repository.UserRepository;

@Configuration
@Import({DaoSpringConfig.class})
public class RepositoryConfig {
    @Autowired
    private DaoSpringConfig daoSpringConfig;//NOPMD
    @Autowired
    private UserDao userDao;

    public UserRepository userRepository() {
        return new DbUserRepository(userDao);
    }
}
