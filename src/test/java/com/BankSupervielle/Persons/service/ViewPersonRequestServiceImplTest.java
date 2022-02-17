package com.BankSupervielle.Persons.service;

import com.citybank.persons.exception.PersonNoExistException;
import com.citybank.persons.model.Address;
import com.citybank.persons.model.Contact;
import com.citybank.persons.model.Person;
import com.citybank.persons.repository.R2dbcAddressRepository;
import com.citybank.persons.repository.R2dbcContactRepository;
import com.citybank.persons.repository.R2dbcPersonRepository;
import com.citybank.persons.service.impl.ViewPersonRequestServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Log4j2
@ExtendWith(SpringExtension.class)
public class ViewPersonRequestServiceImplTest {

    @Mock
    private R2dbcPersonRepository personRepository;
    @Mock
    private R2dbcContactRepository contactRepository;
    @Mock
    private R2dbcAddressRepository addressRepository;

    @InjectMocks
    private ViewPersonRequestServiceImpl service;

    private Long idRequest;
    private Person expected;
    private Mono<Person> response;


    @Test
    void givenRequestWhenExecuteThenIsOk() {
        givenRequest();
        givenResponse();
        givenRepository();
        whenExecute();
        ThenIsOk();
    }

    private void givenRequest() {
        idRequest = 1L;
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

    private void givenRepository() {

        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.just(expected));
        Mockito.when(addressRepository.findByPersonId(idRequest)).thenReturn(Mono.just(expected.getAddress()));
        Mockito.when(contactRepository.findByPersonId(idRequest)).thenReturn(Mono.just(expected.getContact()));
    }

    private void whenExecute() {
        response = service.execute(idRequest);
    }

    private void ThenIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(person -> {
                    log.info("valores de person {}",person);
                    log.info("valores de expected {}",expected);

                   return person.equals(expected);
                })
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(idRequest);
        Mockito.verify(contactRepository).findByPersonId(idRequest);
        Mockito.verify(addressRepository).findByPersonId(idRequest);
    }

    @Test
    void givenRequestWhenExecuteThenItemAddressNull(){
        givenRequest();
        givenResponseWithItemAddressNull();
        givenRepositoryWithItemAddressNull();
        whenExecuteWithItemAddressNull();
        thenItemAddressNull();
    }

    private void givenResponseWithItemAddressNull() {
        expected = Person.builder()
                .id(1L)
                .name("sebastian")
                .contact(Contact.builder()
                        .id(2L)
                        .mail("Sebastianhg479@Gmail.com")
                        .personId(1L)
                        .build())
                .documentNational(95764679L)
                .build();
    }

    private void givenRepositoryWithItemAddressNull() {
        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.just(expected));
        Mockito.when(addressRepository.findByPersonId(idRequest)).thenReturn(Mono.empty());
        Mockito.when(contactRepository.findByPersonId(idRequest)).thenReturn(Mono.just(expected.getContact()));
    }

    private void whenExecuteWithItemAddressNull() {
        response = service.execute(idRequest);
    }

    private void thenItemAddressNull() {
        StepVerifier.create(response)
                .expectNextMatches(person -> person.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(idRequest);
        Mockito.verify(addressRepository).findByPersonId(idRequest);
        Mockito.verify(contactRepository).findByPersonId(idRequest);
    }

    @Test
    void givenRequestWhenExecuteThenItemContactIsNull() {
        givenRequest();
        givenResponseWithContactNull();
        givenRepositoryWithContactNull();
        whenExecuteWithContactNull();
        thenContactIsNull();
    }

    private void givenResponseWithContactNull() {
        expected= Person.builder()
                .id(1L)
                .documentNational(95764679L)
                .name("Jose Perez")
                .address(Address.builder()
                                .id(2L)
                                .personId(1L)
                                .city("Caracas")
                                .build()
                )
                .build();
    }

    private void givenRepositoryWithContactNull() {
        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.just(expected));
        Mockito.when(addressRepository.findByPersonId(expected.getId())).thenReturn(Mono.just(expected.getAddress()));
        Mockito.when(contactRepository.findByPersonId(expected.getId())).thenReturn(Mono.empty());
    }

    private void whenExecuteWithContactNull() {
        response = service.execute(idRequest);
    }

    private void thenContactIsNull() {
        StepVerifier.create(response)
                .expectNextMatches(person -> person.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(personRepository).findById(idRequest);
        Mockito.verify(addressRepository).findByPersonId(idRequest);
        Mockito.verify(contactRepository).findByPersonId(idRequest);
    }

    @Test
    void givenRequestWhenExecuteThenPersonNoExist(){
        givenRequest();
        givenRepositoryPersonNoExist();
        whenExecutePersonNoExists();
        thenPersonNoExists();
    }

    private void givenRepositoryPersonNoExist() {
        Mockito.when(personRepository.findById(idRequest)).thenReturn(Mono.empty());
    }

    private void whenExecutePersonNoExists() {
        response = service.execute(idRequest);
    }

    private void thenPersonNoExists() {
            StepVerifier.create(response)
                    .expectErrorMatches(e -> e instanceof PersonNoExistException).verify();

        Mockito.verify(personRepository).findById(idRequest);
    }
}
