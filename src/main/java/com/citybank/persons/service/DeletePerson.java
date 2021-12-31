package com.citybank.persons.service;

import reactor.core.publisher.Mono;

public interface DeletePerson {
    Mono<Void> execute(Long documentNational);
}
