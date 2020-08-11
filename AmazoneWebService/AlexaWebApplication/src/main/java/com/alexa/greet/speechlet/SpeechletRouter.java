package com.alexa.greet.speechlet;

import com.alexa.greet.service.*;
import com.alexa.greet.service.business.DefaultExceptionHandlingService;
import com.alexa.greet.service.business.ServiceOneImpl;
import com.alexa.greet.service.business.ServiceTwoImpl;
import com.alexa.greet.service.utils.*;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SpeechletRouter implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(SpeechletRouter.class);
    private static final Service welcomeService = new WelcomeServiceImpl();
    private static final Service goodByeService = new GoodByeServiceImpl();
    private static final Service serviceOne = new ServiceOneImpl();
    private static final Service serviceTwo = new ServiceTwoImpl();
    private static final Service helpService = new HelpServiceImpl();
    private static final Service aboutMeService = new AboutMeServiceImpl();
    private static final SessionService sessionService = new SessionService();
    private static final DefaultExceptionHandlingService defaultExceptionHandlingService = new DefaultExceptionHandlingService();
    private static final CallBackService callBackService = new CallBackService();

    // init on launch callback
    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        return this.callBackService.onLaunch(request, session, log);
    }

    // on session start callback
    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        this.sessionService.sessionStartCallback(request, session, log);
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest intentRequest, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={} ,intentRequest={}", intentRequest.getRequestId(),
                session.getSessionId(), intentRequest);

        Intent intent = intentRequest.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("welcome_note".equals(intentName)) {
            return this.welcomeService.getService(intentRequest);
        } else if ("ServiceOne".equals(intentName)) {
            return this.serviceOne.getService(intentRequest);
        } else if ("ServiceTwo".equals(intentName)) {
            return this.serviceTwo.getService(intentRequest);
        } else if ("about_me".equalsIgnoreCase(intentName)) {
            return this.aboutMeService.getService(intentRequest);
        } else if ("goodbye_note".equalsIgnoreCase(intentName)) {
            return this.goodByeService.getService(intentRequest);
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return this.helpService.getService(intentRequest);
        } else if (intentName == null) {
            return this.defaultExceptionHandlingService.getService(intentRequest);
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    //clean up call back
    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        this.sessionService.sessionEndCallback(request, session, log);
    }
}
