package ru.igrey.dev.repository;

import ru.igrey.dev.domain.event.CategoryEvent;

import java.util.List;

public interface CategoryEventRepository {

    List<CategoryEvent> findAll();
    CategoryEvent save(CategoryEvent event);
}
