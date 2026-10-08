package com.geisivan.taskservice.infrastructure.exception.custom;

import org.springframework.http.HttpStatus;

public class EnvironmentVariableNotFoundException extends ApiException {

    private static final String MESSAGE =
            "Required environment variable '%s' is not defined";

    public EnvironmentVariableNotFoundException(String variableName) {
        super(String.format(MESSAGE, variableName), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
