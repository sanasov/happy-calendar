package ru.igrey.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.igrey.dev.dao.CategoryEventDao;
import ru.igrey.dev.dao.EventDao;
import ru.igrey.dev.dao.UserDao;
import ru.igrey.dev.repository.*;

@Configuration
@Import({DaoSpringConfig.class})
public class RepositorySpringConfig {

    @Autowired
    private DaoSpringConfig daoSpringConfig;//NOPMD
    @Autowired
    private UserDao userDao;
    @Autowired
    private CategoryEventDao categoryEventDao;
    @Autowired
    private EventDao eventDao;

    @Bean
    public UserRepository userRepository() {
        return new DbUserRepository(userDao);
    }

    @Bean
    public CategoryEventRepository categoryEventRepository() {
        return new DbCategoryEventRepository(categoryEventDao);
    }

    @Bean
    public EventRepository eventRepository() {
        return new DbEventRepository(eventDao);
    }

}
