package com.citybank.persons.repository.reactive.impl;

import com.citybank.persons.model.Person;
import com.citybank.persons.repository.jpa.JpaPersonRepository;
import com.citybank.persons.repository.reactive.ReactivePersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class ReactivePersonRepositoryImpl implements ReactivePersonRepository {
    private final JpaPersonRepository jpaPersonRepository;

    @Override
    public Mono<Person> getPersonById(Long id) {
        var searchPerson = jpaPersonRepository.findById(id);
        return searchPerson.map(Mono::just).orElseGet(Mono::empty);
    }

    @Override
    public Mono<Person> updatePerson(Person newPerson) {
        var searchPerson = jpaPersonRepository.findById(newPerson.getDocumentNational());
        return (searchPerson.isPresent())
                ? Mono.just(jpaPersonRepository.save(
                Person.builder()
                        .age(newPerson.getAge())
                        .country(newPerson.getCountry())
                        .gender(newPerson.getGender())
                        .typeDocument(newPerson.getTypeDocument())
                        .name(newPerson.getName())
                        .build()))
                : Mono.empty();
    }

    @Override
    public Mono<Person> createPerson(Person person) {
        var newPerson = jpaPersonRepository.findById(person.getDocumentNational());
        return (newPerson.isPresent())
                ? Mono.empty()
                : Mono.just(jpaPersonRepository.save(Person.builder()
                        .documentNational(person.getDocumentNational())
                        .age(person.getAge())
                        .country(person.getCountry())
                        .gender(person.getGender())
                        .name(person.getName())
                        .direction(person.getDirection())
                        .contact(person.getContact())
                        .build()));
    }

    @Override
    public Mono<Void> deletePersonVoid(Long id) {
        var deletePerson = jpaPersonRepository.findById(id);
        if (deletePerson.isPresent()) {
            jpaPersonRepository.deleteById(id);
            return Mono.empty().then();
        }
        return Mono.empty();

    }

    @Override
    public Mono<Boolean> deletePersonBoolean(Long id) {
        if (jpaPersonRepository.existsById(id)) {
            jpaPersonRepository.deleteById(id);
            return Mono.just(Boolean.TRUE);
        }
        return Mono.empty();
    }
}
