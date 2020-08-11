package com.espark.adarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationLocalMain {

    /*step 3 for war file generation comment below method */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationLocalMain.class, args);
    }
}
