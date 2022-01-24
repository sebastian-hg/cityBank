package com.citybank.persons.service;

import com.citybank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface UpdatePersonRequestService {
    Mono<Person> execute(Person UpdatePerson);
}
