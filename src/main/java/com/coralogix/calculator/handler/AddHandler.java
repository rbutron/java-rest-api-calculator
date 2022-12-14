package com.coralogix.calculator.handler;

import com.coralogix.calculator.services.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class AddHandler {

    private AddService addService;

    public Mono<ServerResponse> add(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(addService.add(request.queryParam("a")
                        .map(Integer::parseInt).orElse(0), request.queryParam("b")
                        .map(Integer::parseInt).orElse(0))));
    }

    @Autowired
    public void setInjectionAddService(AddService addService) {
        this.addService = addService;
    }
}
