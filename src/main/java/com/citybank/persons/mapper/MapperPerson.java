package com.citybank.persons.mapper;

import com.citybank.persons.model.Person;
import org.mapstruct.Mapper;

@Mapper
public interface MapperPerson {
    Person personToDataBase(Person person);
}
