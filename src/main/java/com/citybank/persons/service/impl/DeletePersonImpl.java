package com.citybank.persons.service.impl;

import com.citybank.persons.repository.jpa.JpaPersonRepository;
import com.citybank.persons.service.DeletePerson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class DeletePersonImpl implements DeletePerson {
    private final JpaPersonRepository repository;

    @Override
    public Mono<Void> execute(Long documentNational) {
        return null;
//        return Mono.just(documentNational)
//                .map(repository::existsById)
//                .switchIfEmpty(PersonNoExistException::new)
//                .flatMap()
//
//    }
//
//    Mono<Long> validDatePerson(Long dni) {
//        return Mono.just( repository.findById(dni))
//                .flatMap(person -> person.get())
//
//         return dni;
    }
}

//Mono.just(documentNational).zipWith(monoResult)
//        .map(x->repository.existsById(x.getT1()))
//        .map(aBoolean -> repository.delete(aBoolean.))
//        .switchIfEmpty(Mono.error(PersonNoExistException::new))