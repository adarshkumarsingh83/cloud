package com.espark.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class EsparkJavaLambda implements RequestHandler<String,String>{

    public String handleRequest(String name, Context context) {
        LambdaLogger logger = context.getLogger();
        String message = "Welcome to the of Espark World " + name;
        logger.log("EsparkJavaLambda -> esparkJavaLamHandler Executed " + message);
        return message;
    }
}
