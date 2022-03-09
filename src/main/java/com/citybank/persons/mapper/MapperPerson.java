package com.citybank.persons.mapper;

import com.citybank.persons.model.Person;
import com.citybank.persons.model.dto.request.PersonDtoRequest;
import com.citybank.persons.model.dto.response.PersonDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface MapperPerson {


    @Mapping(target = "dni", source = "documentNational")
    @Mapping(target = "country", expression = "java(person.getAddress().getCountry())")
    @Mapping(target = "mail",expression = "java(person.getContact().getMail())")
    @Mapping(target = "phone", expression = "java(person.getContact().getNumberCall())")
    PersonDtoResponse toPersonDtoResponse(Person person);

    Person toPerson(PersonDtoResponse personDto);

    Person toPerson(PersonDtoRequest personDtoRequest);
}
