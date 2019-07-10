package com.espark.adarsh.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class GreetingsRestController {

    private final String greetings;

    public GreetingsRestController(@Value("${wish}") String greetings) {
        this.greetings = greetings;
    }

    @GetMapping("/wish")
    String greetings() {
        return this.greetings;
    }
}

