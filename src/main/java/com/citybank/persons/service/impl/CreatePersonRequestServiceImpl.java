package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.CreatePersonRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class CreatePersonRequestServiceImpl implements CreatePersonRequestService {

    private final R2dbcPersonRepository personRepository;
    private final R2dbcAddressRepository addressRepository;
    private final R2dbcContactRepository contactRepository;

    @Override
    public Mono<Person> execute(Person person) {
        return personRepository.save(person)
                .flatMap(this::saveAddressAndContact);
    }

    private Mono<Person> saveAddressAndContact(Person person){
        person.getContact().setPersonId(person.getId());
        person.getAddress().setPersonId(person.getId());
       return contactRepository.save(person.getContact())
                .zipWith(addressRepository.save(person.getAddress()))
               .thenReturn(person);
    }
}
