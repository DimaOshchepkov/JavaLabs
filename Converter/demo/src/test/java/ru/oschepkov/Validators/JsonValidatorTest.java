package ru.oschepkov.Validators;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class JsonValidatorTest {

    @Test
    public void testIsValid() throws IOException {
        IValidator validator = new JsonValidator();
        assertTrue(validator.isValid("src\\main\\resourses\\out.json"));
    }
}
