package ru.igrey.dev.view;

import java.util.List;

public class CategoryEventView {

  private Long id;
        private String title;
        private String description;
        private List<EventView> events;


        public CategoryEventView(Long id, String title, String description, List<EventView> events) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.events = events;
        }

        public CategoryEventView() {
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

        public List<EventView> getEvents() {
            return events;
        }

        public void setEvents(List<EventView> events) {
            this.events = events;
        }
    }
