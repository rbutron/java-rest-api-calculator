package com.coralogix.calculator.repository;

import com.coralogix.calculator.repository.entity.ExchangeRateEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExchangeRateRepository extends ReactiveCrudRepository<ExchangeRateEntity, Long> {
}
