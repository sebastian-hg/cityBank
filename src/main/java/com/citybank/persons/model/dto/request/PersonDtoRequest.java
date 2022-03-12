package com.citybank.persons.model.dto.request;

import lombok.*;

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
    @NotNull(message = "the document is necessary")
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
