package com.javamentor.test.exceptions;

public class OperationFormatException extends Exception {
    public OperationFormatException(String errorMessage) {
        super(errorMessage);
    }

    public OperationFormatException() {
        super("Допустима только оперции +, -, *, /");
    }
}
