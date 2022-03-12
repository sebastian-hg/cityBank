package com.citybank.persons.model.dto.request;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
@Setter
public class ContactDtoRequest {
    private Long id;
    private String mail;
    @NotNull
    private Integer numberCall;
    private Long personId;
}
