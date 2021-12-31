package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.service.UpdatePerson;
import reactor.core.publisher.Mono;

public class UpdatePersonImpl implements UpdatePerson {
    @Override
    public Mono<Person> execute(Person person) {
        return null;
    }
}
