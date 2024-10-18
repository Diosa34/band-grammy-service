package com.musicbands.bandgrammyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.musicbands.musicbandsservice.repositories",
                                        "com.musicbands.bandgrammyservice.repositories, " +
                                                "com.musicbands.musicbandsservice.mappers"})
@SpringBootApplication
public class BandGrammyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BandGrammyServiceApplication.class, args);
    }

}
