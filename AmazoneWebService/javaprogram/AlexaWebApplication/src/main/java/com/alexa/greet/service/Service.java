package com.alexa.greet.service;


import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

public interface Service {

    public SpeechletResponse getService(IntentRequest intentRequest);
}
