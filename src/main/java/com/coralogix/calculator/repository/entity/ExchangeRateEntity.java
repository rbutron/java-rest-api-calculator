package com.coralogix.calculator.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateEntity {
    @Id
    private Long id;
    private String originCurrency;
    private String finalCurrency;
    private String date;
    private BigDecimal value;
}
