package com.coralogix.calculator.handler;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.Status;
import com.coralogix.calculator.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ExchangeRateHandler {

    private static final String MESSAGE = "Item saved";
    private ExchangeRateService exchangeRateService;

    @Autowired
    public void setExchangeRateService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public Mono<ServerResponse> saveExchangeRate(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ExchangeRate.class).map(exchangeRate -> this.exchangeRateService.saveExchangeRate(exchangeRate))
                .flatMap(ignore -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(Status.builder()
                                .body(MESSAGE)
                        .build())));
    }
}
