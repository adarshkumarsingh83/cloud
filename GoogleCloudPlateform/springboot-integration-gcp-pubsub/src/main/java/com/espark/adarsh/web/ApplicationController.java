package com.espark.adarsh.web;

import com.espark.adarsh.service.PublishingService;
import com.espark.adarsh.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ApplicationController {

    @Autowired
    private PublishingService publishingService;

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/publish/{message}")
    public void publish(@PathVariable String message) {
        publishingService.sendMessage(message);
    }


    @PostMapping("/subscribing")
    public Optional<String> subscribing() {
        return subscriberService.getMessage();
    }

}
