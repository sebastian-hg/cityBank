package com.cityBank.persons.service.impl;

import com.cityBank.persons.service.DeletePerson;
import reactor.core.publisher.Mono;

public class DeletePersonImpl implements DeletePerson {
    @Override
    public Mono<Void> execute(Integer documentNational) {
        return null;
    }
}
