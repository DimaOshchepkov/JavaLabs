package ru.oschepkov.Validators;

import java.io.IOException;

public interface IValidator {
    boolean isValid(String path) throws IOException;
}
