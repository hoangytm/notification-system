package com.hoangyth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableAsync
public class ProducerApplication {

    public static void main(String[] args) throws RestClientException, IOException, InterruptedException {
        SpringApplication.run(
                ProducerApplication.class, args);

    }

}
