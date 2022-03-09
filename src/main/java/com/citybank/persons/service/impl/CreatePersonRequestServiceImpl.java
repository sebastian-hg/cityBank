package com.citybank.persons.service.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.CreatePersonRequestService;
import com.citybank.persons.service.SaveAddressAndContactService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class CreatePersonRequestServiceImpl implements CreatePersonRequestService {

    private final R2dbcPersonRepository personRepository;
    private final SaveAddressAndContactService saveAddressAndContact;


    @Override
    public Mono<Person> execute(Person person) {
        return personRepository.save(person)
                .flatMap(saveAddressAndContact::execute);
    }

}
