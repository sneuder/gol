package com.gol.globalException;

public class GlobalException extends Exception {
    private ErrorMessage errorMessage;

    public GlobalException(String message, ErrorMessage errorMessage) {
        super(errorMessage.getMessage() +  " " + message);
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
