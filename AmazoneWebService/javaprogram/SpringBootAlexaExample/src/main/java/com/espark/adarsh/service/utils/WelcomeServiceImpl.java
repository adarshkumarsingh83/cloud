package com.espark.adarsh.service.utils;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import com.espark.adarsh.service.Service;

@org.springframework.stereotype.Service("serviceWelcome")
public class WelcomeServiceImpl implements Service {

    @Override
    public SpeechletResponse getService() {
        String speechText = "Hello From Alexa";

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("GreetWorld");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
}
