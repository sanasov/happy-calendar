package ru.igrey.dev.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akhovanskii on 23.12.2016.
 */
@Slf4j
@RestController
@RequestMapping(method = RequestMethod.GET)
public class HpController {

    @RequestMapping("/hello")
    public String dashboard() {
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("INDEX HELLO");
        return "hello";
    }

}
