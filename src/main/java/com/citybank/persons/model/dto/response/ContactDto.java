package com.citybank.persons.model.dto.response;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ContactDto implements IResponseSuccess {
    String mail;
    Integer numberCall;

}
