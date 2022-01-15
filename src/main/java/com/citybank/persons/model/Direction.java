package com.citybank.persons.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
@Entity
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
}
