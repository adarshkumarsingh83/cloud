package com.espark.adarsh.controller;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.MessageService;
import com.espark.adarsh.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class ApplicationController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageBean message) {
        logger.info("label='send-controller' {}", message);
        this.messageService.send(message);
    }

    @GetMapping("/message")
    public MessageBean getMessage() {
        MessageBean data = this.messageService.receive();
        logger.info("label='get-controller' {}", data);
        return data;
    }

}
