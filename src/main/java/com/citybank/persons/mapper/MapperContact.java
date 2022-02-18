package com.citybank.persons.mapper;

import com.citybank.persons.model.Contact;
import com.citybank.persons.model.dto.response.ContactDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperContact {

    ContactDto toContactDto(Contact contact);

    Contact toContact(ContactDto contactDto);
}
