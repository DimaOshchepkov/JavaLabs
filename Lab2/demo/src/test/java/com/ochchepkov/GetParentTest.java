package com.ochchepkov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GetParentTest extends OutputRedirector{
    @Test
    void testApply() {
        (new GetParent()).apply(path);
        assertTrue(outputStream.toString().contains("src\\test\\resources"));
    }

    @Test
    void testNoParent() {
        assertThrows(IllegalArgumentException.class,
                () -> (new GetParent()).apply("D:\\"));
    }

    @Test
    void testIncorrectPath() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> (new GetParent()).apply(path + "sdlf"));

        assertEquals("No such directory", exception.getMessage()); 
    }
}
