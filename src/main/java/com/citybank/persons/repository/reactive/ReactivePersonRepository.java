package com.citybank.persons.repository.reactive;

import com.citybank.persons.model.Person;
import reactor.core.publisher.Mono;

public interface ReactivePersonRepository {
    Mono<Person> getPersonById(Long id);

    Mono<Person> updatePerson(Person newPerson);

    Mono<Person> createPerson(Person person);

    Mono<Boolean> deletePersonBoolean(Long id);

    Mono<Void> deletePersonVoid(Long id);
}
