package ru.igrey.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akhovanskii on 23.12.2016.
 */
@RestController
@RequestMapping(method = RequestMethod.GET)
public class HpController {
    private Logger logger = LoggerFactory.getLogger(HpController.class);
    @RequestMapping("/hello")
    public String dashboard() {
        logger.info("INDEX HELLO");
        return "hello";
    }

}
