package com.cityBank.persons.service;

import reactor.core.publisher.Mono;

public interface DeletePerson {
    Mono<Void> execute(Integer documentNational);
}
