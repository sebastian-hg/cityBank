package com.citybank.persons.mapper;

import com.citybank.persons.model.Contact;
import org.mapstruct.Mapper;

@Mapper
public interface MapperContact {
    Contact mapperToDataBase(Contact contact);
}
