package ru.oschepkov.converterexeption;

public class WriteFileException extends Exception {
    
    public WriteFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
