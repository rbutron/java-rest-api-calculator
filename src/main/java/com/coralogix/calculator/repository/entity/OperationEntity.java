package com.coralogix.calculator.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationEntity {
    @Id
    private Long id;
    private BigDecimal operationResult;
    private BigDecimal firstField;
    private BigDecimal secondField;
    private String operation;
}
