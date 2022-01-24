package com.citybank.persons.mapper;

import com.citybank.persons.model.Address;
import org.mapstruct.Mapper;

@Mapper
public interface MapperAddress {
    Address addressToDataBase(Address address);
}
