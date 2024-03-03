package com.akobir.eop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EopApplication.class, args);
    }

}
