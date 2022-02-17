package com.citybank.persons.service.impl;

import com.citybank.persons.exception.PersonNoExistException;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.SaveAddressAndContactService;
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
    private final SaveAddressAndContactService saveAddressAndContact;

    @Override
    public Mono<Person> execute(Person updatePerson) {
        return personRepository.existsById(updatePerson.getId())
                .filter(Boolean.TRUE::equals)
                .switchIfEmpty(Mono.error(PersonNoExistException::new))
                .flatMap(aBoolean -> personRepository.save(updatePerson))
                .flatMap(saveAddressAndContact::execute);
    }
}



