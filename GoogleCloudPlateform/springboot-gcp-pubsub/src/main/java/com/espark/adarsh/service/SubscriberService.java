package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
class SubscriberService {

    private final PubSubTemplate template;
    private final String subscription;

    public SubscriberService(PubSubTemplate template, @Value("${espark.subscription:espark-subscription}")
            String s) {
        this.template = template;
        this.subscription = s;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {

        this.template.subscribe(this.subscription, (pubsubMessage, ackReply ) -> {
            log.info("consumed new message: [" + pubsubMessage.getData().toStringUtf8() + "]");
            ackReply.ack();
        });
    }
}
