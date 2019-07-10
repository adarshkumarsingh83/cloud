package com.espark.adarsh.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Configuration
public class PublisherConfig {

    private final String topic;
    private final PubSubTemplate template;

    public PublisherConfig(
            @Value("${espark.topic:espark}") String t,
            PubSubTemplate template) {
        this.topic = t;
        this.template = template;
    }

    @Bean
    public IntegrationFlow publisherFlow() {
        return IntegrationFlows
                .from(this.outgoing())
                .handle(this.pubSubMessageHandler())
                .get();
    }


    @Bean
    public SubscribableChannel outgoing() {
        return MessageChannels.direct().get();
    }

    @Bean
    public PubSubMessageHandler pubSubMessageHandler() {
        return new PubSubMessageHandler(template, this.topic);
    }
}