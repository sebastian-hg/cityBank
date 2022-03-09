package com.citybank.persons.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class RequestRestrictionException extends Exception {

    public RequestRestrictionException(String message) {
        super(message);
    }
}
