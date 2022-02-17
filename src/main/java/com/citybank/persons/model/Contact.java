package com.citybank.persons.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Table
public class Contact {

    @Id
    private Long id;
    private String mail;
    private Integer numberCall;
    private Long personId;
}
