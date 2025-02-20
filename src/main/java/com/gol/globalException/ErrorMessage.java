package com.gol.globalException;

public enum ErrorMessage {
    DATA_TYPE_INTEGER("It must be an integer."),
    DATA_NOT_EMPTY("It cannot be empty."),
    DATA_TYPE_INTEGER_RANGE("It has to follow the range."),
    DATA_PARAMS_AMOUNT("Invalid number of arguments.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}