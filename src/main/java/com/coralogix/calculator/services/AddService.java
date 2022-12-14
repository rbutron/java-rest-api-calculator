package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {

    private OperationRepository operationRepository;

    public Result add(int a, int b) {
        int sum = a + b;
        return new Result(sum);
    }

    @Autowired
    public void setInjectOperationRepository(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }
}
