package com.citybank.persons.mapper;

import com.citybank.persons.model.Person;
import com.citybank.persons.model.dto.response.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperPerson {
    PersonDto personDto(Person person);

    Person person(PersonDto personDto);
}
