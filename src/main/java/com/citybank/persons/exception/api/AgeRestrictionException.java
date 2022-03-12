package com.citybank.persons.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class AgeRestrictionException extends Exception {

    public AgeRestrictionException(String message) {
        super(message);
    }
}
