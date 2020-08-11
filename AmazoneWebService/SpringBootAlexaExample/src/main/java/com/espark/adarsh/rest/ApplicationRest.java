package com.espark.adarsh.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class ApplicationRest {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, String> welcome() {

        return new HashMap<String, String>() {
            {
                put("message", "WELCOME TO THE SPRING BOOT ALEXA ");
                put("time", new Date().toString());
            }
        };
    }

}
