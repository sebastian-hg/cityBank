package com.cityBank.persons.service;

import com.cityBank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface ViewAllPerson {
    Mono<Person> execute();
}
