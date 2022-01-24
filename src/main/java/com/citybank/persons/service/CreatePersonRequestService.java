package com.citybank.persons.service;

import com.citybank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface CreatePersonRequestService {
    Mono<Person> execute(Person person);

}
