package ru.oschepkov.converterexeption;

public class UnknownFileTypeException extends Exception {
    
    public UnknownFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownFileTypeException(String message) {
        super(message);
    }
}
