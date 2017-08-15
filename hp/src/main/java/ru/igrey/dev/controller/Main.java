package ru.igrey.dev.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akhovanskii on 23.12.2016.
 */
@Slf4j
@Controller
@RequestMapping(method = RequestMethod.GET)
public class Main {

    @RequestMapping(value = "/")
    public String home() {
        log.info("INDEX HELLO");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/403")
    public String accesssDenied() {
        return "403";
    }
}
