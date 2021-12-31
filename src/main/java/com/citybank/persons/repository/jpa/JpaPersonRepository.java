package com.citybank.persons.repository.jpa;

import com.citybank.persons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPersonRepository extends JpaRepository<Person, Long> {
}
