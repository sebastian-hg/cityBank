package com.BankSupervielle.Persons.service;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.Contact;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.impl.UpdatePersonRequestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class UpdatePersonRequestServiceImplTest {
    @Mock
    private R2dbcPersonRepository personRepository;
    @Mock
    private R2dbcAddressRepository addressRepository;
    @Mock
    private R2dbcContactRepository contactRepository;

    @InjectMocks
    private UpdatePersonRequestServiceImpl service;

    private Person oldPerson;
    private Person personRequest;
    private Person expected;
    private Mono<Person> response;


    @Test
    void givenRequestWhenExecuteThenUpdateIsOk() {
        givenRequest();
        givenResponse();
        givenRepository();
        whenExecute();
        thenUpdateIsOk();
    }

    private void givenRequest() {
        personRequest = Person.builder()
                .id(1L)
                .name("jose")
                .documentNational(95764679L)
                .address(Address.builder()
                        .id(2L)
                        .city("Miami")
                        .country("United States")
                        .build())
                .contact(Contact.builder()
                        .id(2L)
                        .mail("jose@gmail.com")
                        .numberCall(1127620035)
                        .build())
                .build();
    }

    private void givenResponse() {
        expected = Person.builder()
                .id(1L)
                .name("jose")
                .documentNational(95764679L)
                .address(Address.builder()
                        .id(2L)
                        .city("Miami")
                        .country("United States")
                        .personId(1L)
                        .build())
                .contact(Contact.builder()
                        .id(2L)
                        .mail("jose@gmail.com")
                        .numberCall(1127620035)
                        .personId(1L)
                        .build())
                .build();
    }

    private void givenRepository() {
        oldPerson = Person.builder()
                .id(1L)
                .name("mario Casa")
                .address(Address.builder()
                        .personId(1L)
                        .country("venezuela")
                        .build())
                .contact(Contact.builder()
                        .personId(1L)
                        .numberCall(1127620035)
                        .build())
                .build();
        Mockito.when(personRepository.findById(personRequest.getId())).thenReturn(Mono.just(oldPerson));
        Mockito.when(personRepository.save(personRequest)).thenReturn(Mono.just(personRequest));
        Mockito.when(addressRepository.save(personRequest.getAddress())).thenReturn(Mono.just(personRequest.getAddress()));
        Mockito.when(contactRepository.save(personRequest.getContact())).thenReturn(Mono.just(personRequest.getContact()));
    }

    private void whenExecute() {
        response = service.execute(personRequest);
    }

    private void thenUpdateIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(person -> person.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(personRequest.getId());
        Mockito.verify(personRepository).save(personRequest);
        Mockito.verify(addressRepository).save(personRequest.getAddress());
        Mockito.verify(contactRepository).save(personRequest.getContact());
    }
}
