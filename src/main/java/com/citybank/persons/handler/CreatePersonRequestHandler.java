package com.citybank.persons.handler;

import com.citybank.persons.exception.api.RequestRestrictionException;
import com.citybank.persons.helper.ResponseHelper;
import com.citybank.persons.mapper.MapperPerson;
import com.citybank.persons.model.dto.request.PersonDtoRequest;
import com.citybank.persons.service.CreatePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Component
@AllArgsConstructor
public class CreatePersonRequestHandler {

    private final Validator validator;
    private final ResponseHelper responseHelper;
    private final CreatePersonRequestService service;
    private final MapperPerson mapperPerson;

    public @NonNull Mono<ServerResponse> execute(ServerRequest serverRequest) {
        log.info("Body validation with request {} ...", serverRequest);
        return validateBodyAndExecute(serverRequest);
    }

    private Mono<ServerResponse> validateBodyAndExecute(ServerRequest serverRequest) {
        log.info("proceed to validate data to person{}",serverRequest.methodName());
        return serverRequest.bodyToMono(PersonDtoRequest.class)
                .flatMap(body -> {
                    Errors errors = new BeanPropertyBindingResult(body, "PersonDtoRequest");
                    validator.validate(body, errors);
                    if (errors.getAllErrors().isEmpty()) {
                        return executeRuleBusiness(Mono.just(body));
                    } else {
                        log.error("Found errors errrrrroooooorrrrrrrr{} ...", errors);
                        return Mono.error(new RequestRestrictionException("these fields do not meet the restrictions"
                                + errors));
                    }
                })
                .switchIfEmpty(Mono.error(new Exception()));
    }

    private Mono<ServerResponse> executeRuleBusiness(Mono<PersonDtoRequest> personDtoResponse) {
        log.info("execute rule of business");
        return personDtoResponse.map(mapperPerson::toPerson)
                .flatMap(service::execute)
                .flatMap(person -> {
                    return responseHelper.buildOK(Mono.just(person));
                });

    }

}


