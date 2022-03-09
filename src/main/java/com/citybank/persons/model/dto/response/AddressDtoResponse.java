package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
@Setter
public class AddressDtoResponse implements IResponseSuccess {
    String city;
    String street;

}
