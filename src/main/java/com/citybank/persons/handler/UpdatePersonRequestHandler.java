package com.citybank.persons.handler;

import com.citybank.persons.helper.ResponseHelper;
import com.citybank.persons.model.Person;
import com.citybank.persons.service.UpdatePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
@Log4j2
public class UpdatePersonRequestHandler {

    private final UpdatePersonRequestService service;
    private final ResponseHelper responseHelper;

    public @NonNull Mono<ServerResponse> executeWithBodyValidation(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        return serverRequest.bodyToMono(Person.class)
                .flatMap(service::execute)
                .flatMap(person -> responseHelper.buildOK(Mono.just(person)));
    }
}
