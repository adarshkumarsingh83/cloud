package com.alexa.greet.service.business;

import com.alexa.greet.service.Service;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;


public class ServiceTwoImpl implements Service {

    private static final String speechText = "Welcome to the Alexa Service Two";

    @Override
    public SpeechletResponse getService(IntentRequest intentRequest) {

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("WelcomeToAlexaServiceTwo");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }
}
