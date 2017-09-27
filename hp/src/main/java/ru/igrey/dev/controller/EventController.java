package ru.igrey.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.igrey.dev.domain.event.CategoryEvent;
import ru.igrey.dev.repository.CategoryEventRepository;
import ru.igrey.dev.view.CategoryEventView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akhovanskii on 23.12.2016.
 */
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private CategoryEventRepository categoryEventRepository;

    @GetMapping("all-categories")
    public List<CategoryEventView> findAllCategoryEvents() {
        return categoryEventRepository.findAll().stream()
                .map(CategoryEvent::toView)
                .collect(Collectors.toList());
    }

}
