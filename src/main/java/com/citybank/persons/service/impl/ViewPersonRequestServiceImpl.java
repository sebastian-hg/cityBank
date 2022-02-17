package com.citybank.persons.service.impl;

import com.citybank.persons.exception.PersonNoExistException;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.ViewPersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class ViewPersonRequestServiceImpl implements ViewPersonRequestService {

    private R2dbcPersonRepository personRepository;
    private R2dbcAddressRepository addressRepository;
    private R2dbcContactRepository contactRepository;

    @Override
    public Mono<Person> execute(Long id) {
        return personRepository.findById(id)
                .flatMap(person -> addressRepository.findByPersonId(person.getId())
                        .map(
                                address -> {
                                    person.setAddress(address);
                                    return person;
                                }
                        )
                        .switchIfEmpty(Mono.just(person))
                )
                .flatMap(person -> contactRepository.findByPersonId(person.getId())
                        .map(
                                contact -> {
                                    person.setContact(contact);
                                    return person;
                                }
                        )
                        .switchIfEmpty(Mono.just(person))
                )
                .switchIfEmpty(Mono.error(PersonNoExistException::new));
    }


}
