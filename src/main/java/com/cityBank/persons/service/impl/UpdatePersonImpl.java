package com.cityBank.persons.service.impl;

import com.cityBank.persons.model.Person;
import com.cityBank.persons.service.UpdatePerson;
import reactor.core.publisher.Mono;

public class UpdatePersonImpl implements UpdatePerson {
    @Override
    public Mono<Person> execute(Person person) {
        return null;
    }
}
