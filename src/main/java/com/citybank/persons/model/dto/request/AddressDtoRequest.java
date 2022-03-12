package com.citybank.persons.model.dto.request;


import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class AddressDtoRequest {
    private Long id;
    @NotNull
    private String street;
    @NotNull
    private String country;
    private String city;
    private Integer postalCode;
    private Long personId;

}
