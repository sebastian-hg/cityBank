package com.citybank.persons.mapper;

import com.citybank.persons.model.Contact;
import com.citybank.persons.model.dto.response.ContactDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperContact {

    ContactDtoResponse toContactDto(Contact contact);

    Contact toContact(ContactDtoResponse contactDto);
}
