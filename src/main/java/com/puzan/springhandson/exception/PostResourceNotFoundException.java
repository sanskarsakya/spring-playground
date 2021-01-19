package com.puzan.springhandson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostResourceNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PostResourceNotFoundException() {
        super();
    }

    public PostResourceNotFoundException(String message) {
        super(message);
    }

    public PostResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}