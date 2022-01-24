package com.BankSupervielle.Persons.service;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.Contact;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.impl.CreatePersonRequestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class SavePersonRequestServiceTest {
    @Mock
    private R2dbcPersonRepository personRepository;
    @Mock
    private R2dbcContactRepository contactRepository;
    @Mock
    private R2dbcAddressRepository addressRepository;
    @InjectMocks
    private CreatePersonRequestServiceImpl service;

    private Person request;
    private Person expected;
    private Mono<Person> response;

    @Test
    void givenRequestWhenExecuteThenIsOK() {
        givenRequest();
        givenRepository();
        givenResponse();
        whenExecute();
        thenIsOk();
    }

    private void givenRequest() {
        request = Person.builder()
                .name("sebastian")
                .contact(Contact.builder()
                        .mail("Sebastianhg479@Gmail.com")
                        .build())
                .address(Address.builder()
                        .city("Buenos Aires")
                        .postalCode(1041)
                        .build())
                .documentNational(95764679L)
                .build();
    }

    private void givenRepository() {
        var person = Person.builder()
                .id(1L)
                .name("sebastian")
                .contact(Contact.builder()
                        .id(2L)
                        .mail("Sebastianhg479@Gmail.com")
                        .build())
                .address(Address.builder()
                        .id(2L)
                        .city("Buenos Aires")
                        .postalCode(1041)
                        .build())
                .documentNational(95764679L)
                .build();

        Mockito.when(personRepository.save(any(Person.class)))
                .thenReturn(Mono.just(person));
        Mockito.when(contactRepository.save(any(Contact.class)))
                .thenReturn(Mono.just(person.getContact()));
        Mockito.when(addressRepository.save(any(Address.class)))
                .thenReturn(Mono.just(person.getAddress()));
    }

    private void givenResponse() {
        expected = Person.builder()
                .id(1L)
                .name("sebastian")
                .contact(Contact.builder()
                        .id(2L)
                        .mail("Sebastianhg479@Gmail.com")
                        .personId(1L)
                        .build())
                .address(Address.builder()
                        .id(2L)
                        .city("Buenos Aires")
                        .postalCode(1041)
                        .personId(1L)
                        .build())
                .documentNational(95764679L)
                .build();
    }

    private void whenExecute() {
        response = service.execute(request);
    }

    private void thenIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(person -> person.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).save(any(Person.class));
        Mockito.verify(contactRepository).save(any(Contact.class));
        Mockito.verify(addressRepository).save(any(Address.class));
    }
}

