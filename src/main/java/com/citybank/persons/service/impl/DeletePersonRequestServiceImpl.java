package com.citybank.persons.service.impl;

import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.DeletePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class DeletePersonRequestServiceImpl implements DeletePersonRequestService {
    private final R2dbcPersonRepository personRepository;
    private final R2dbcContactRepository contactRepository;
    private final R2dbcAddressRepository addressRepository;

    @Override
    public Mono<Boolean> execute(Long id) {
        return personRepository.findById(id)
                .flatMap(person -> contactRepository.findByPerson(person.getId())
                        .map(contact -> {
                            contactRepository.delete(contact);
                            return person;
                        }
                        )
                )
                .flatMap(person -> addressRepository.findByPerson(person.getId())
                        .map(address -> {
                            addressRepository.delete(address);
                            return person;
                        })
                )
                .map(person -> {
                            personRepository.delete(person);
                            return Boolean.TRUE;
                        }
                )
                .switchIfEmpty(Mono.just(Boolean.FALSE));


    }
}

