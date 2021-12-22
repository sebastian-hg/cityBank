package com.cityBank.persons.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class Person {
    @Id
    private Long documentNational;
    private String typeDocument;
    private String country;
    private String gender;
    private Integer age;
    private String name;


}
