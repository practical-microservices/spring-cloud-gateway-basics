package com.example.ebapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EbApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbApiGatewayApplication.class, args);
	}

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("prices", r -> r.path("/prices")
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8090"))
				.build();

	}
}
