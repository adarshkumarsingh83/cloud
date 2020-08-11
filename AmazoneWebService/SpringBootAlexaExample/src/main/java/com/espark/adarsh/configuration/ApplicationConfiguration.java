package com.espark.adarsh.configuration;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import com.espark.adarsh.speechlet.GreetSpeechlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired(required = true)
    private GreetSpeechlet greetSpeechlet;

    @Bean
    public ServletRegistrationBean registerServlet() {
        final SpeechletServlet speechletServlet = new SpeechletServlet();
        speechletServlet.setSpeechlet(this.greetSpeechlet);
        return new ServletRegistrationBean(speechletServlet, "/alexa");
    }

}
