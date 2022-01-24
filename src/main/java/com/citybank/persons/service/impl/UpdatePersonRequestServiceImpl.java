package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.UpdatePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class UpdatePersonRequestServiceImpl implements UpdatePersonRequestService {

    private final R2dbcPersonRepository personRepository;
    private final R2dbcAddressRepository addressRepository;
    private final R2dbcContactRepository contactRepository;

    @Override
    public Mono<Person> execute(Person updatePerson) {
        return personRepository.save(updatePerson)
                .map(person -> {
                    var address = person.getAddress();
                    address.setPersonId(person.getId());
                    addressRepository.save(address);
                    return person;
                })
                .map(person -> {
                    var contact = person.getContact();
                    contact.setPersonId(person.getId());
                    contactRepository.save(contact);
                    return person;
                });
    }
}

