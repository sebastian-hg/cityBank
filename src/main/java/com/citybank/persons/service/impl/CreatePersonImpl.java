package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.repository.reactive.ReactivePersonRepository;
import com.citybank.persons.service.CreatePerson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreatePersonImpl implements CreatePerson {
    private final ReactivePersonRepository repository;

    @Override
    public Mono<Person> execute(Person person) {
       return repository.createPerson(person);
    }
}
