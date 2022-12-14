package com.coralogix.calculator.repository;

import com.coralogix.calculator.repository.entity.OperationEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface OperationRepository extends ReactiveCrudRepository<OperationEntity, Long> {
    @Query("SELECT * FROM operation_entity o WHERE o.id = $1")
    Mono<OperationEntity> findById(Long id);
}
