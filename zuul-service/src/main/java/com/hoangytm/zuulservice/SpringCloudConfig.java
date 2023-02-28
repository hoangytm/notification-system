package com.hoangytm.zuulservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    //    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/consumer/**")
//                        .uri("http://localhost:9000/")
//                        .id("employeeModule"))
//
//                .route(r -> r.path("/producer/**")
//                        .uri("http://localhost:8082/")
//                        .id("consumerModule"))
//                .build();
//    }
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // 用户服务
                .route("producer", r -> r.path("/producer/**").filters(f -> f.stripPrefix(1)).uri("localhost:9000/"))
                // 基础服务
                .route("consumer", r -> r.path("/consumer/**").filters(f -> f.stripPrefix(1)).uri("localhost:9001/"))
                // 文章服务
//                .route("article_route", a -> a.path("/ar/**").filters(f -> f.stripPrefix(1)).uri("lb://SERVICE-ARTICLE"))
//
//                // 授权、鉴权、第三方登录
//                .route("auth_route", a -> a.path("/oauth/**").filters(f -> f.stripPrefix(0)).uri("lb://AUTHENTICATION-SERVER"))
//                .route("social_route", a -> a.path("/social/**").filters(f -> f.stripPrefix(1)).uri("lb://AUTHENTICATION-SERVER"))
//
//                // API
//                .route("api_base_route", r -> r.path("/api/ba/**").filters(f -> f.stripPrefix(0)).uri("lb://SERVICE-BASE"))
//                .route("api_article_route", a -> a.path("/api/ar/**").filters(f -> f.stripPrefix(0)).uri("lb://SERVICE-ARTICLE"))
//                .route("api_user_route", a -> a.path("/api/su/**").filters(f -> f.stripPrefix(0)).uri("lb://SERVICE-USER"))

                .build();
    }

}