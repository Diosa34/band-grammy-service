package com.musicbands.bandgrammyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan("com.musicbands.bandgrammyservice.config.properties")
public class BandGrammyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BandGrammyServiceApplication.class, args);
    }
}
