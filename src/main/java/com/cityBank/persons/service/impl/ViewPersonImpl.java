package com.cityBank.persons.service.impl;

import com.cityBank.persons.exception.PersonNoExistException;
import com.cityBank.persons.model.Person;
import com.cityBank.persons.repository.PersonRepository;
import com.cityBank.persons.service.ViewPerson;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class ViewPersonImpl implements ViewPerson {

    private final PersonRepository repository;

    @Override
    public Mono<Person> execute(Long documentNational) {
        return Mono.just(documentNational)
                .map(repository::findById)
                .flatMap(employeeOp -> employeeOp.map(Mono::just).orElseGet(() -> Mono.error(PersonNoExistException::new))
                );


    }
}
