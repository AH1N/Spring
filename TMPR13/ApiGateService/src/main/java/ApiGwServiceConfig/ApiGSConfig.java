package ApiGwServiceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGSConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("TestOne", r -> r.path("Test1/TestOne.java")
                        .uri("http://localhost:8080")) // Пример маршрута к сервису 1
//                .route("service2_route", r -> r.path("/service2/**")
//                        .uri("http://localhost:8082")) // Пример маршрута к сервису 2
                .build();
    }
}
