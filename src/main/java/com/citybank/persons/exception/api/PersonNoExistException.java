package com.citybank.persons.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class PersonNoExistException extends Exception {

    public PersonNoExistException(String message) {
        super(message);
    }

    public PersonNoExistException() {

    }
}
