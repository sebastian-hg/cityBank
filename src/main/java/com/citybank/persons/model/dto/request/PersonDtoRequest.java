package com.citybank.persons.model.dto.request;

import com.citybank.persons.model.Address;
import com.citybank.persons.model.Contact;
import lombok.*;
import org.springframework.data.annotation.Transient;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
@Setter
public class PersonDtoRequest {
    private Long id;
    @Size(min = 7, max = 8)
    private Long documentNational;
    private String typeDocument;
    private String gender;
    @NotNull(message = "can not be null")
    private Integer age;
    @NotNull(message = "name not can  be null")
    private String name;
    @Valid
    private AddressDtoRequest address;
    @Valid
    private ContactDtoRequest contact;


}
