package edu.miu.sa.Project.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private static final Logger LOG = LogManager.getLogger(MyController.class);

    @GetMapping("/hello")
    public String helloMessage() {
            LOG.log(Level.INFO, "Hello World");

        return "Hello World";
    }
}
