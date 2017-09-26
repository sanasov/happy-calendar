package ru.igrey.dev.repository;

import ru.igrey.dev.dao.EventDao;

import ru.igrey.dev.domain.event.Event;
import ru.igrey.dev.entity.event.EventEntity;

public class DbEventRepository implements EventRepository{

    private EventDao eventDao;

    public DbEventRepository(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event findById(Long login) {
        return Event.fromEntity(eventDao.select(login));
    }

    @Override
    public Event save(Event event) {
        EventEntity savedEntity = event.toEntity();
        if (event == null) {
            eventDao.insert(savedEntity);
        } else {
            eventDao.update(savedEntity);
        }
        return Event.fromEntity(savedEntity);
    }
}
