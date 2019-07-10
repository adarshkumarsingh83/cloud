package com.epsark.adarsh.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ApplicationConfig {

    @Bean
    ImageAnnotatorClient imageAnnotatorClient(
            CredentialsProvider credentialsProvider) throws IOException {
        ImageAnnotatorSettings settings = ImageAnnotatorSettings
                .newBuilder()
                .setCredentialsProvider(credentialsProvider)
                .build();
        return ImageAnnotatorClient.create(settings);
    }
}
