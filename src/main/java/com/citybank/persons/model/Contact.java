package com.citybank.persons.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;
    private Integer numberCall;
    private String mail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
}