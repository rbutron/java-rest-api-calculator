package com.coralogix.calculator.router;

import com.coralogix.calculator.handler.ExchangeRateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class ExchangeRateRouter {
    @Bean
    public RouterFunction<ServerResponse> saveExchangeRate(ExchangeRateHandler exchangeRateHandler) {
        return RouterFunctions.route(RequestPredicates.POST("exchange-rate").and(accept(MediaType.APPLICATION_JSON)), exchangeRateHandler::saveExchangeRate);
    }
}
