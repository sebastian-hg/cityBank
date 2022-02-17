package com.citybank.persons.handler;

import com.citybank.persons.helper.ResponseHelper;
import com.citybank.persons.service.DeletePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
@Log4j2
public class DeletePersonRequestHandler {
    private final DeletePersonRequestService service;
    public final ResponseHelper responseHelper;

    public Mono<ServerResponse> executeWithoutBodyValidation(ServerRequest serverRequest) {
        var idRequest = serverRequest.queryParam("id").get();
        var idDelete= Long.parseLong(idRequest);
        log.info("delete person with id: {}", idDelete);
        return service.execute(idDelete)
                .flatMap(aBoolean ->{return responseHelper.buildOK();});
    }
}
