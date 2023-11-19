package com.ochchepkov;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LSTest extends OutputRedirector{

    @Test
    void testCorrect() {
        (new LS()).apply(path);
        assertTrue(outputStream.toString().length() < 100);
        assertTrue(outputStream.toString().length() > 50);
    }

    @Test
    void testIncorrectPath() {
        assertThrows(IllegalArgumentException.class,
                () -> (new LS()).apply("src\\test\\resources\\testFo"));
    }
}
