package com.espark.adarsh.web;

import com.espark.adarsh.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    PublisherService publisherService;

    @PostMapping("/publish/{message}")
    public void publish(@PathVariable String message) {
       this.publisherService.sendMessage(message);
    }
}
