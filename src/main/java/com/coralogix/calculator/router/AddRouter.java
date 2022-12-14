package com.coralogix.calculator.router;

import com.coralogix.calculator.handler.AddHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class AddRouter {
    @Bean
    public RouterFunction<ServerResponse> addRoute(AddHandler addHandler) {

        return RouterFunctions
                .route(GET("/add").and(accept(MediaType.APPLICATION_JSON)), addHandler::add);
    }
}
