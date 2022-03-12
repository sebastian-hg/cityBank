package com.citybank.persons.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestRestrictionException extends Exception {

    public RequestRestrictionException(String message) {
        super(message);
    }
}
