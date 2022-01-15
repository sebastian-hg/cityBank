package com.citybank.persons.controller;

import com.citybank.persons.model.Person;
import com.citybank.persons.service.ViewPerson;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("CityBank/person")
public class GetPersonByIdController {

    private final ViewPerson service;

    @GetMapping
    public Mono<Person> execute(@RequestParam("id") Long id){
        return service.execute(id);
    }
}
