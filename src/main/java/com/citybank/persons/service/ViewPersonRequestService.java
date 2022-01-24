package com.citybank.persons.service;

import com.citybank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface ViewPersonRequestService {
    Mono<Person> execute(Long id);
}
