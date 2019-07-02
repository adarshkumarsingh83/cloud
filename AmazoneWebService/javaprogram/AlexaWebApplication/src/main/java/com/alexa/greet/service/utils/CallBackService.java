package com.alexa.greet.service.utils;

import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import org.slf4j.Logger;

public class CallBackService {

    private static final String speechText = "Welcome From Alexa";

    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session, final Logger log)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return this.getMessage();
    }


    private SpeechletResponse getMessage() {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("GreetFromAlexa");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
}
