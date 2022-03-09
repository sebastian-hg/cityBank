package com.citybank.persons.repository;

import com.citybank.persons.model.Contact;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface R2dbcContactRepository extends ReactiveCrudRepository<Contact, Long> {
    Mono<Contact> findByPersonId(Long id);
    Mono<Void> deleteByPersonId(Long id);

}
