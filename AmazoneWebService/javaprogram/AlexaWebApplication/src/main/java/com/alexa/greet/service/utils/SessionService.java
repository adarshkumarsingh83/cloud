package com.alexa.greet.service.utils;

import com.amazon.speech.speechlet.*;
import org.slf4j.Logger;

public class SessionService {

    public SpeechletResponse sessionStartCallback(final SessionStartedRequest request, final Session session, Logger log)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}"
                , request.getRequestId(),session.getSessionId());
        return null;
    }

    public SpeechletResponse sessionEndCallback(final SessionEndedRequest request, final Session session, Logger log)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}"
                , request.getRequestId(), session.getSessionId());
        return null;
    }
}
