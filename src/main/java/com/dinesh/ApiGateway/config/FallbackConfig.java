package com.dinesh.ApiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

public class FallbackConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .filters(f -> f.circuitBreaker(h -> h.setName("Hystrix")
                                .setFallbackUri("forward:/user-service")))
                        .uri("lb://USER-SERVICE"))
                .route(r -> r.path("/departments/**")
                        .filters(f -> f.circuitBreaker(h -> h.setName("Hystrix")
                                .setFallbackUri("forward:/department-service")))
                        .uri("lb://DEPARTMENT-SERVICE"))
                .build();
    }

}
