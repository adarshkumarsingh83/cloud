package com.espark.adarsh.service;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SubscriberService {

    @Autowired
    private MessageChannel messageChannel;

    public Optional<String> getMessage() {
        Optional<String> optional = Optional.empty();
        IntegrationFlows.from(this.messageChannel)
                .handle(message -> {
                    AckReplyConsumer consumer = message.getHeaders()
                            .get(GcpPubSubHeaders.ACKNOWLEDGEMENT, AckReplyConsumer.class);
                    log.info("received message : [" + message.getPayload() + "]");
                    optional.of(message.getPayload().toString());
                    consumer.ack();
                });
        return optional;
    }
}
