package com.sda.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2Application {

    private static final Logger logger = LoggerFactory.getLogger(SpringBoot2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class);
        logger.info("---now i can use all components");
        //create spring context
        //run command line runners
        //run application

    }
}
