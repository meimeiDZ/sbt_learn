package com.mmdz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RmSbtScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(RmSbtScheduledApplication.class, args);
    }

}
