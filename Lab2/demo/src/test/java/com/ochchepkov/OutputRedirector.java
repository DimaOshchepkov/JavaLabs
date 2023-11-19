package com.ochchepkov;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputRedirector {

    static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    static PrintStream printStream = new PrintStream(outputStream);
    static PrintStream oldOut = System.out;

    String path = "src\\test\\resources\\testFolder";

    @BeforeAll
    public static void setUp() throws Exception {
        System.setOut(printStream);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        System.setOut(oldOut);
    }
}
