package com.example.obspringsecurityjwtroles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {

    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);//409 estas intentando guardar datos pero ya existe datos con ese email
    }
}
