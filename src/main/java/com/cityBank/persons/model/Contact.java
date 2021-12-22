package com.cityBank.persons.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
@Entity
public class Contact {
    @Id
    private Long id;
    private String address;
    private Integer numberCall;
}
