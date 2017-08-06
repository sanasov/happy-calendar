package ru.igrey.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akhovanskii on 23.12.2016.
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class Main {

    private Logger logger = LoggerFactory.getLogger(Main.class);
    @RequestMapping(value = "/")
    public String home() {
        logger.info("INDEX HELLO");
        return "index";
    }
}
