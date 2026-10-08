package com.geisivan.taskservice.infrastructure.exception.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    protected ApiException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}
