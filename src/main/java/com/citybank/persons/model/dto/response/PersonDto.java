package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class PersonDto implements IResponseSuccess {
    String name;
    Long document;
    String country;
    String mail;
    Integer numberCall;
}
