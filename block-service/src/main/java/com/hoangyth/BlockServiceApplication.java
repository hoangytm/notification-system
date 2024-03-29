package com.hoangyth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
public class BlockServiceApplication {

    public static void main(String[] args) throws RestClientException, IOException, InterruptedException {
        ApplicationContext ctx = SpringApplication.run(
                BlockServiceApplication.class, args);

    }

}
