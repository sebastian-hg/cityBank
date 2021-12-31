package com.citybank.persons.service.impl;

import com.citybank.persons.exception.PersonNoExistException;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.jpa.JpaPersonRepository;
import com.citybank.persons.service.ViewPerson;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class ViewPersonImpl implements ViewPerson {

    private final JpaPersonRepository repository;

    @Override
    public Mono<Person> execute(Long documentNational) {
        return Mono.just(documentNational)
                .map(repository::findById)
                .flatMap(employeeOp -> employeeOp.map(Mono::just).orElseGet(() -> Mono.error(PersonNoExistException::new))
                );
    }
}
