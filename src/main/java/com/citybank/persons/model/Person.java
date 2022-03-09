package com.citybank.persons.model;

import com.citybank.persons.helper.IResponseSuccess;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Table
public class Person  implements IResponseSuccess {

    @Id
    private Long id;
    private Long documentNational;
    private String typeDocument;
    private String gender;
    @NotNull(message = "can not be null")
    private Integer age;
    private String name;
    @Transient
    private Address address;
    @Transient
    private Contact contact;


}
