package ru.igrey.dev.repository;

import ru.igrey.dev.dao.CategoryEventDao;
import ru.igrey.dev.domain.event.CategoryEvent;
import ru.igrey.dev.entity.event.CategoryEventEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DbCategoryEventRepository implements CategoryEventRepository {

    private CategoryEventDao dao;

    public DbCategoryEventRepository(CategoryEventDao dao) {
        this.dao = dao;
    }

    @Override
    public List<CategoryEvent> findAll() {
        return dao.selectAll()
                .stream()
                .map(CategoryEvent::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryEvent find(Long id) {
        return CategoryEvent.fromEntity(dao.select(id));
    }

    @Override
    public CategoryEvent save(CategoryEvent categoryEvent) {
        CategoryEventEntity savedEntity = categoryEvent.toEntity();
        if (savedEntity.getId() == null) {
            dao.insert(savedEntity);
        } else {
            dao.update(savedEntity);
        }
        return CategoryEvent.fromEntity(savedEntity);
    }
}
