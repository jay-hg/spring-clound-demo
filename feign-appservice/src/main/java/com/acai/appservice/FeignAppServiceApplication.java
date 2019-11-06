package com.acai.appservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FeignAppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignAppServiceApplication.class, args);
    }
}
