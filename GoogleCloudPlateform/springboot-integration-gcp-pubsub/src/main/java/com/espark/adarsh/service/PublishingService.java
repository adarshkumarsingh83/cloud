package com.espark.adarsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {

    @Autowired
    private SubscribableChannel subscribableChannel;

    public void sendMessage(String message){
        this.subscribableChannel.send(MessageBuilder.withPayload(message).build());
    }
}
