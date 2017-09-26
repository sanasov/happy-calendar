package ru.igrey.dev.entity.event;

import java.util.List;

public class CategoryEventEntity {

    private Long id;
    private String title;
    private String description;
    private List<EventEntity> events;


    public CategoryEventEntity(Long id, String title, String description, List<EventEntity> events) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.events = events;
    }

    public CategoryEventEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }
}
