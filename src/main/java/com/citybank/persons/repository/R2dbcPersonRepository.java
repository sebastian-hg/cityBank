package com.citybank.persons.repository;

import com.citybank.persons.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface R2dbcPersonRepository extends ReactiveCrudRepository<Person,Long> {
}
