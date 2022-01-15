package com.citybank.persons.controller;

import com.citybank.persons.model.Person;
import com.citybank.persons.service.impl.CreatePersonImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("CityBank/person/create")
public class CreatePersonController {

    private final CreatePersonImpl service;

    @PostMapping
    public Mono<Person> createPerson (@RequestBody Person newPerson){
        return service.execute(newPerson);
    }

}
