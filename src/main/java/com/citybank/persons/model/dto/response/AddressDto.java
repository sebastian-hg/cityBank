package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class AddressDto implements IResponseSuccess {
    String city;
    String street;

}
