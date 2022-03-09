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
    @NotNull
    @Email
    private String mail;
    @NotBlank
    @Min(1100000000)
    @Max(1199999999)
    private Integer numberCall;
    private Long personId;
}
