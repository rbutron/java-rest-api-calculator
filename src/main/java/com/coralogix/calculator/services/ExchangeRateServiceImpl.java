package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Currency;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.repository.ExchangeRateRepository;
import com.coralogix.calculator.repository.entity.ExchangeRateEntity;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final WebClient webClient;

    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Autowired
    public void setExchangeRateRepository(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Mono<Void> saveExchangeRate(ExchangeRate exchangeRate) {
        var entity = Mono.from(buildExchangeRateEntity(exchangeRate)).block();
        if (Objects.nonNull(entity)) {
            return this.exchangeRateRepository.save(entity).thenEmpty(Mono.empty());
        } else {
            return Mono.error(new Exception("Currency not found"));
        }
    }

    private Publisher<ExchangeRateEntity> buildExchangeRateEntity(ExchangeRate exchangeRate) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/latest")
                        .queryParam("base", exchangeRate.getOriginCurrency())
                        .queryParam("symbols", exchangeRate.getFinalCurrency())
                        .build())
                .retrieve()
                .bodyToMono(Currency.class)
                .map(getCurrency -> ExchangeRateEntity.builder()
                        .originCurrency(exchangeRate.getOriginCurrency())
                        .finalCurrency(exchangeRate.getFinalCurrency())
                        .date(getCurrency.getDate())
                        .value(getCurrency.getRates().getPen())
                        .build());
    }
}
