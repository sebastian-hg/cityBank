package com.citybank.persons.handler;

import com.citybank.persons.helper.ResponseHelper;
import com.citybank.persons.mapper.MapperPerson;
import com.citybank.persons.service.ViewPersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Component
@AllArgsConstructor
public class ViewPersonByIdHandler {

    private final ResponseHelper responseHelper;
    private final ViewPersonRequestService service;
    private final MapperPerson mapperPerson;


    public Mono<ServerResponse> executeWithoutBodyValidation(ServerRequest serverRequest) {
        var personId = (serverRequest.queryParam("id").get());
        var id = Long.parseLong(personId);
        log.info("id request is {}", id);
        return service.execute(id)
                .flatMap(person -> {
                    return responseHelper.buildOK(Mono.just(mapperPerson.personDto(person)));
                });
    }


}
