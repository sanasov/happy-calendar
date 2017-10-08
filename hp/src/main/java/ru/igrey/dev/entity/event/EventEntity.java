package ru.igrey.dev.entity.event;

import java.time.LocalDateTime;

public class EventEntity {

    private Long id;
    private String title;
    private LocalDateTime dateTime;
    private String description;
    private Long categoryId;

    public EventEntity(Long id, String title, LocalDateTime dateTime, String description, Long categoryId) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.categoryId = categoryId;
    }

    public EventEntity() {
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
