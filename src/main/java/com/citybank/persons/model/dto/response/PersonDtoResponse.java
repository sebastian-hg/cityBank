package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Setter
@Builder
public class PersonDtoResponse implements IResponseSuccess {
    String name;
    Integer age;
    Long dni;
    String country;
    String mail;
    Integer phone;
}
