package com.citybank.persons.service;

import com.citybank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface CreatePerson {
    Mono<Person> execute(Person person);
}
