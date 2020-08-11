package com.espark.adarsh.speechlet;


import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.espark.adarsh.service.Service;
import com.espark.adarsh.service.business.DefaultExceptionHandlingService;
import com.espark.adarsh.service.business.ServiceOneImpl;
import com.espark.adarsh.service.business.ServiceTwoImpl;
import com.espark.adarsh.service.utils.HelpServiceImpl;
import com.espark.adarsh.service.utils.SessionService;
import com.espark.adarsh.service.utils.WelcomeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class GreetSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(GreetSpeechlet.class);

    @Qualifier(value = "serviceWelcome")
    @Autowired(required = true)
    private final Service welcomeService =null;

    @Qualifier(value = "serviceOne")
    @Autowired(required = true)
    private  final Service serviceOne =null;

    @Qualifier(value = "serviceTwo")
    @Autowired(required = true)
    private  final Service serviceTwo =null;

    @Qualifier(value = "serviceHelp")
    @Autowired(required = true)
    private  final Service helpService =null;

    @Qualifier(value = "sessionService")
    @Autowired(required = true)
    private  final SessionService sessionService =new SessionService();

    @Qualifier(value = "exceptionHandler")
    @Autowired(required = true)
    private  final DefaultExceptionHandlingService defaultExceptionHandlingService =null;

    // init on launch callback
    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return this.welcomeService.getService();
    }

    // on session start callback
    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        this.sessionService.sessionStartCallback(request,session,log);
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={} ,request={}", request.getRequestId(),
                session.getSessionId(),request);

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("GreetIntent".equals(intentName)) {
            return this.welcomeService.getService();
        } else if ("ServiceOne".equals(intentName)) {
            return this.serviceOne.getService();
        } else if ("ServiceTwo".equals(intentName)) {
            return this.serviceTwo.getService();
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return this.helpService.getService();
        } else if (intentName == null){
             return this.defaultExceptionHandlingService.getService();
        }else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    //clean up call back
    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        this.sessionService.sessionEndCallback(request,session,log);
    }
}
