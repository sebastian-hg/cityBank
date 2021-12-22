package com.BankSupervielle.Persons.service;

import com.cityBank.persons.model.Person;
import com.cityBank.persons.repository.PersonRepository;
import com.cityBank.persons.service.impl.ViewPersonImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ViewPersonImplTest {

    private Person person;
    private Long document;
    private Person expected;
    private Mono<Person> response;
    private Optional personOp;

    @InjectMocks
    private ViewPersonImpl service;
    @Mock
    private PersonRepository repository;

    @Test
    void givenRequestWhenExecuteThenIsOK() {
        givenRequest();
        givenResponse();
        givenRepository();
        whenExecute();
        thenIsOK();
    }

    private void givenRequest() {
        document = 95764679L;
    }

    private void givenResponse() {
        expected = (Person.builder()
                .documentNational(95764679L)
                .typeDocument("Dni")
                .country("argentina")
                .name("sebastian")
                .build());
    }

    private void givenRepository() {
        Person person = Person.builder()
                .documentNational(95764679L)
                .typeDocument("Dni")
                .country("argentina")
                .name("sebastian")
                .build();
        Mockito.when(repository.findById(document)).thenReturn(Optional.of(person));
    }

    private void whenExecute() {
        response = service.execute(document);
    }

    private void thenIsOK() {
        StepVerifier.create(response)
                .expectNextMatches(person1 -> person1.equals(expected))
                .expectComplete()
                .verify();
        Mockito.verify(repository).findById(document);
    }
}
