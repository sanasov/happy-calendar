package ru.igrey.dev.view;

import java.time.LocalDateTime;

public class EventView {

    private Long id;
    private String title;
    private LocalDateTime dateTime;
    private String description;

    public EventView(Long id, String title, LocalDateTime dateTime, String description) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
    }

    public EventView() {
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
}
