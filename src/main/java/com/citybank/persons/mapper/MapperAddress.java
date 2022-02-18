package com.citybank.persons.mapper;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.dto.response.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperAddress {

    Address toAddress(AddressDto addressDto);

    AddressDto toAddressDto(Address address);

}
