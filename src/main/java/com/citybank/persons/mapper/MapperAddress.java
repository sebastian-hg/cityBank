package com.citybank.persons.mapper;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.dto.response.AddressDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperAddress {

    Address toAddress(AddressDtoResponse addressDto);

    AddressDtoResponse toAddressDto(Address address);

}
