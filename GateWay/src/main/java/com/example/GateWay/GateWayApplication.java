package com.example.GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/clients/**").uri("lb://SERVICE-CLIENT"))
				.build();
	}
}
