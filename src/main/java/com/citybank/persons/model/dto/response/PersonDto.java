package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import com.citybank.persons.model.Address;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class PersonDto implements IResponseSuccess {
    String name;
    Integer age;
    Long documentNational;
    Address country;
    String mail;
    Integer numberCall;
}
