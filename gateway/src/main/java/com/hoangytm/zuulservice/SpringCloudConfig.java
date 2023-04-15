package com.hoangytm.zuulservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("producer", r -> r.path("/producer/**").filters(f -> f.stripPrefix(1)).uri("lb://producer"))
                .route("consumer", r -> r.path("/consumer/**").filters(f -> f.stripPrefix(1)).uri("lb://comsumer"))
                .route("search-service", r -> r.path("/search-service/**").filters(f -> f.stripPrefix(1)).uri("lb://search-service"))
                .build();
    }

}