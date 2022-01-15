package com.citybank.persons.model;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long documentNational = 0L;
    private String typeDocument;
    private String country;
    private String gender;
    private Integer age;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direction_id")
    private Direction direction;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;


}
