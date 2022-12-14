package com.coralogix.calculator.services;

import com.coralogix.calculator.model.ExchangeRate;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {
    Mono<Void> saveExchangeRate(ExchangeRate exchangeRate);
}
