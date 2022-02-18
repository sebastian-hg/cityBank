package com.citybank.persons.mapper;

import com.citybank.persons.model.Person;
import com.citybank.persons.model.dto.response.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface MapperPerson {


    @Mapping(source = "address", target = "country")
    PersonDto personDto(Person person);

    Person person(PersonDto personDto);
}
