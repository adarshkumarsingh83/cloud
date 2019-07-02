package com.espark.adarsh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationWebMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationWebMain.class);
    }

  /*  step 4 for war file generation uncomment below method*/
   /* public static void main(String[] args) {
        SpringApplication.run(ApplicationWebMain.class, args);
    }*/
}
