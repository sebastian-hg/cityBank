package com.citybank.persons.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Table
public class Address {

    private Long id;
    private String street;
    private String country;
    private String city;
    private Integer postalCode;
    private Long personId;
}
