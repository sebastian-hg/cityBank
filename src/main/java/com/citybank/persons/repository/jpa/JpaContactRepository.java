package com.citybank.persons.repository.jpa;

import com.citybank.persons.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaContactRepository extends JpaRepository<Contact, Long> {
}
