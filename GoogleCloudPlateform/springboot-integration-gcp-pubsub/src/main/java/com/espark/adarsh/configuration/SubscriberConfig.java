package com.espark.adarsh.configuration;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Slf4j
@Configuration
public class SubscriberConfig {

    private final String subscription;
    private final PubSubTemplate template;

    public SubscriberConfig(
            @Value("${espark.subscription:respark.subscription}") String subscription,
            PubSubTemplate template) {
        this.subscription = subscription;
        this.template = template;
    }

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter() {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(
                template, this.subscription);
        adapter.setOutputChannel(this.incoming());
        adapter.setAckMode(AckMode.MANUAL);
        return adapter;
    }

    @Bean
    public MessageChannel incoming() {
        return MessageChannels.publishSubscribe().get();
    }

}