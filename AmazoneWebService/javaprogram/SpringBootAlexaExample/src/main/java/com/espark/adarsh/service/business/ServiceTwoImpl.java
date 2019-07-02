package com.espark.adarsh.service.business;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.espark.adarsh.service.Service;

@org.springframework.stereotype.Service("serviceTwo")
public class ServiceTwoImpl implements Service {

    @Override
    public SpeechletResponse getService() {
        String speechText = "Welcome to the Alexa Service Two";

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
