package com.BankSupervielle.Persons.service;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.Contact;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.impl.DeletePersonRequestServiceImpl;
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
public class DeletePersonRequestServiceImplTest {
    @Mock
    private R2dbcPersonRepository personRepository;
    @Mock
    private R2dbcAddressRepository addressRepository;
    @Mock
    private R2dbcContactRepository contactRepository;
    @InjectMocks
    private DeletePersonRequestServiceImpl service;

    private Long idRequest;
    private Mono<Boolean> response;
    private Boolean expected;

    @Test
    void givenRequestWhenExecuteThenDeleteIsOk() {
        givenRequest();
        givenResponse();
        givenRepository();
        whenExecute();
        thenDeleteIsOk();
    }

    private void givenRequest() {
        idRequest = 1L;
    }

    private void givenResponse() {
        expected = Boolean.TRUE;
    }

    private void givenRepository() {
        Person responseRepository = Person.builder()
                .id(idRequest)
                .name("jose")
                .contact(Contact.builder()
                        .id(2L)
                        .personId(idRequest)
                        .build())
                .address(Address.builder()
                        .id(2L)
                        .personId(idRequest)
                        .build())
                .build();
        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.just(responseRepository));
        Mockito.when(contactRepository.findByPerson(idRequest)).thenReturn(Mono.just(responseRepository.getContact()));
        Mockito.when(contactRepository.delete(any(Contact.class))).thenReturn(Mono.empty().then());
        Mockito.when(addressRepository.findByPerson(idRequest)).thenReturn(Mono.just(responseRepository.getAddress()));
        Mockito.when(addressRepository.delete(any(Address.class))).thenReturn(Mono.empty().then());
        Mockito.when(personRepository.delete(any(Person.class))).thenReturn(Mono.empty().then());
    }

    private void whenExecute() {
        response = service.execute(idRequest);
    }

    private void thenDeleteIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(x -> x.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(idRequest);
        Mockito.verify(contactRepository).findByPerson(idRequest);
        Mockito.verify(contactRepository).delete(any(Contact.class));
        Mockito.verify(addressRepository).findByPerson(idRequest);
        Mockito.verify(addressRepository).delete(any(Address.class));
        Mockito.verify(personRepository).delete(any(Person.class));
    }

    @Test
    void givenRequestWhenExecuteThenPersonNoExist() {
        givenRequest();
        givenResponseFalse();
        givenRepositoryPersonNoExist();
        whenExecuteWithPersonNoExists();
        thenPersonNoExist();
    }

    private void givenResponseFalse() {
        expected=Boolean.FALSE;
    }

    private void givenRepositoryPersonNoExist() {
        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.empty());
    }

    private void whenExecuteWithPersonNoExists() {
        response=service.execute(idRequest);
    }

    private void thenPersonNoExist() {
        StepVerifier.create(response)
                .expectNextMatches(x->x.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(idRequest);
    }
}
