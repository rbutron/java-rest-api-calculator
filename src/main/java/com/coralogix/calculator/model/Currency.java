package com.coralogix.calculator.model;

import com.coralogix.calculator.model.mapper.Rate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private Boolean success;
    private Long timestamp;
    private String base;
    private String date;
    private Rate rates;
}
