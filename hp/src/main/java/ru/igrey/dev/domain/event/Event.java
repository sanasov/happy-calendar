package ru.igrey.dev.domain.event;

import ru.igrey.dev.entity.event.EventEntity;
import ru.igrey.dev.view.EventView;

import java.time.LocalDateTime;

public class Event {

    private final Long id;
    private final String title;
    private final LocalDateTime dateTime;
    private final String description;

    public Event(Long id, String title, LocalDateTime dateTime, String description) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
    }

    public static Event fromEntity(EventEntity entity) {
        return new Event(entity.getId(), entity.getTitle(), entity.getDateTime(), entity.getDescription());
    }

    public EventEntity toEntity(Long categoryId) {
        return new EventEntity(id, title, dateTime, description, categoryId);
    }

    public static Event fromView(EventView view) {
        return new Event(view.getId(), view.getTitle(), view.getDateTime(), view.getDescription());
    }

    public EventView toView() {
        return new EventView(id, title, dateTime, description);
    }
}
