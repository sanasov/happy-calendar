package ru.igrey.dev.repository;

import ru.igrey.dev.domain.event.Event;

public interface EventRepository {

    Event findById(Long id);
    Event save(Event event, Long categoryId);
}
