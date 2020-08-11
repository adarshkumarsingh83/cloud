package com.alexa.greet.service.utils;

import com.alexa.greet.service.Service;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class HelpServiceImpl implements Service {

    private static final  String speechText = "You can say help to me!";

    @Override
    public SpeechletResponse getService(IntentRequest intentRequest) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("GreetWorld");
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
