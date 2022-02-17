package com.citybank.persons.handler;

import com.citybank.persons.helper.ResponseHelper;
import com.citybank.persons.model.Person;
import com.citybank.persons.service.CreatePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Component
@AllArgsConstructor
public class CreatePersonRequestHandler {
    private final ResponseHelper responseHelper;
    private final CreatePersonRequestService service;

    public  @NonNull Mono<ServerResponse> executeWithBodyValidation(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        return serverRequest.bodyToMono(Person.class)
                .flatMap(service::execute)
                .flatMap(person -> {
                    return responseHelper.buildOK(Mono.just(person));
                });
    }
}
