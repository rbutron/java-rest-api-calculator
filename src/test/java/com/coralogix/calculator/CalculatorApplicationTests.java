package com.coralogix.calculator;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.repository.OperationRepository;
import com.coralogix.calculator.repository.entity.OperationEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

	@Autowired
	private DatabaseClient databaseClient;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testFindByResultCalculatorSubtract() {
		var operationEntity = new OperationEntity(2L, BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1),"RESTA");
		var template = new R2dbcEntityTemplate(databaseClient);
		template.insert(OperationEntity.class).using(operationEntity).then().as(StepVerifier::create).verifyComplete();
		var findByLastName = operationRepository.findById(operationEntity.getId());
		findByLastName.as(StepVerifier::create)
				.assertNext(actual -> {
					assertThat(actual.getOperation()).isEqualTo("RESTA");
					assertThat(actual.getId()).isEqualTo(2L);
				}).verifyComplete();
	}

	@Test
	void testFindByResultCalculatorDataDefault() {
		var findByLastName = operationRepository.findById(1L);
		findByLastName.as(StepVerifier::create)
				.assertNext(actual -> {
					assertThat(actual.getOperation()).isEqualTo("SUMA");
					assertThat(actual.getId()).isEqualTo(1L);
				}).verifyComplete();
	}



	@Test
	void testWebhookAdd() {
		webTestClient
				.get().uri("/add?a=1&b=2")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Result.class).value(result -> {
					assertThat(result.getResult()).isEqualTo(3);
				});
	}

	@Test
	void contextLoads() {
	}

}
