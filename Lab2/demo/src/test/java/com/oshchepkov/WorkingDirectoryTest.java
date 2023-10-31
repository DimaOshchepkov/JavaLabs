package com.oshchepkov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ochchepkov.LS;
import com.ochchepkov.WorkingDirectory;

public class WorkingDirectoryTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;


    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void LSCommandNotRecTest() {
        WorkingDirectory wd = WorkingDirectory.getInstance();
        wd.invoke(new LS());
        wd.apply();
        assertTrue(outContent.toString().length() > 7 && outContent.toString().length() < 15);
    }

    @Test
    public void LSCommandRec() {
        WorkingDirectory wd = WorkingDirectory.getInstance();
        wd.invoke(new LS());
        wd.apply("-R");
        assertTrue(outContent.toString().length() > 100);
    }
    
}
