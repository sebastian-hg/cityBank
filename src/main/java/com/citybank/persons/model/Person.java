package com.citybank.persons.model;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Table
public class Person {

    private Long id;
    private Long documentNational;
    private String typeDocument;
    private String gender;
    private Integer age;
    private String name;
    @Transient
    private Address address;
    @Transient
    private Contact contact;


}
