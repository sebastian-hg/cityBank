package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
public class ContactDtoResponse implements IResponseSuccess {
    String mail;
    Integer numberCall;

}
