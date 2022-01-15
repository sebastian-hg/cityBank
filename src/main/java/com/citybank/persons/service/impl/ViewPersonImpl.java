package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.service.ViewPerson;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class ViewPersonImpl implements ViewPerson {



    @Override
    public Mono<Person> execute(Long documentNational) {
        return null;

    }
}
