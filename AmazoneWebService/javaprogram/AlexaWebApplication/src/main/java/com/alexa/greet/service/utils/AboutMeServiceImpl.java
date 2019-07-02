package com.alexa.greet.service.utils;

import com.alexa.greet.service.Service;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;


public class AboutMeServiceImpl implements Service {

    private static final String speechText = "I am Alexa ";

    @Override
    public SpeechletResponse getService(IntentRequest intentRequest) {

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("AlexaAboutMe");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
}
