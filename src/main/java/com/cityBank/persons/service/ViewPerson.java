package com.cityBank.persons.service;

import com.cityBank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface ViewPerson {
    Mono<Person> execute(Long documentNational);
}
