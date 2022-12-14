package com.coralogix.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {
    private String originCurrency;
    private String finalCurrency;
    private String date;
    private String value;
}
