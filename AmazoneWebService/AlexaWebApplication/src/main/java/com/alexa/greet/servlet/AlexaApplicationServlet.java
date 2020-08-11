package com.alexa.greet.servlet;

import com.alexa.greet.speechlet.SpeechletRouter;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;

public class AlexaApplicationServlet extends SpeechletServlet {

    public AlexaApplicationServlet() {
        this.setSpeechlet(new SpeechletRouter());
    }

}
