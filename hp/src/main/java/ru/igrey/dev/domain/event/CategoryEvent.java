package ru.igrey.dev.domain.event;

import ru.igrey.dev.entity.event.CategoryEventEntity;
import ru.igrey.dev.view.CategoryEventView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryEvent {
    private final Long id;
    private final String title;
    private final String description;
    private final List<Event> events;


    public CategoryEvent(Long id, String title, String description, List<Event> events) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.events = events;
    }


    public CategoryEventEntity toEntity() {
        return new CategoryEventEntity(id, title, description, events.stream().map(event -> event.toEntity(id)).collect(Collectors.toList()));
    }


    public static CategoryEvent fromEntity(CategoryEventEntity entity) {
        return new CategoryEvent(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getEvents().stream().map(Event::fromEntity).collect(Collectors.toList()));
    }


    public CategoryEventView toView() {
        return new CategoryEventView(id, title, description, events.stream().map(Event::toView).collect(Collectors.toList()));
    }


    public static CategoryEvent fromView(CategoryEventView view) {
        return new CategoryEvent(
                view.getId(),
                view.getTitle(),
                view.getDescription(),
                Optional.ofNullable(view.getEvents())
                        .orElse(new ArrayList<>())
                        .stream()
                        .map(Event::fromView).collect(Collectors.toList()));
    }
}
