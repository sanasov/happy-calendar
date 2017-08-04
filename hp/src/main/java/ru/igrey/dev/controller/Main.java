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
//    @PreAuthorize("isFullyAuthenticated() and hasAnyRole('ROLE_MODER_NSPK', 'ROLE_MEMBERS_MODER', 'ROLE_MEMBERS_USER')")
    @RequestMapping(value = "/")
    public String home() {
        logger.info("INDEX HELLO");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/403")
    public String accessDeny() {
        return "403";
    }
}
