package com.espark.adarsh.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

    private final PubSubTemplate template;
    private final String topicName;

    public PublisherService(PubSubTemplate template, @Value("${espark.topicName:espark}") String topicName) {
        this.template = template;
        this.topicName = topicName;
    }

    public void sendMessage(String message){
        this.template.publish(this.topicName, message);
    }

}
