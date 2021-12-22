package com.cityBank.persons.service.impl;

import com.cityBank.persons.model.Person;
import com.cityBank.persons.service.CreatePerson;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreatePersonImpl implements CreatePerson {
    @Override
    public Mono<Person> execute(Person person) {
        return null;
    }
}
