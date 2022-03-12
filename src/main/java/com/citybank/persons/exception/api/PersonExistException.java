package com.citybank.persons.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class PersonExistException extends Exception {

    public PersonExistException(String message) {
        super(message);
    }
}
