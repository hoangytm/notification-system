package com.hoangyth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchServiceApplication {

    public static void main(String[] args) throws RestClientException {
        SpringApplication.run(
                SearchServiceApplication.class, args);

    }
}
