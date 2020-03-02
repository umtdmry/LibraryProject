package com.Library.libraryproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class authorNotFoundException extends RuntimeException {
    public authorNotFoundException(String message) {
        super(message);
    }
}

