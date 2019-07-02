
package com.alexa.greet;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public final class GreetSpeechletRequestStreamHandler
        extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds = new HashSet<String>();

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds.add("amzn1.ask.skill.44fa7898-b04c-48b4-a61a-69184bc08d8c");
    }

    public GreetSpeechletRequestStreamHandler() {

        super(new GreetSpeechlet(), supportedApplicationIds);
    }
}
