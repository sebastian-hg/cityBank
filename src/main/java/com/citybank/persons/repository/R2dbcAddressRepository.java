package com.citybank.persons.repository;

import com.citybank.persons.model.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface R2dbcAddressRepository extends ReactiveCrudRepository<Address,Long> {
    Mono<Address> findByPerson(Long id);
}
