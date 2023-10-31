package com.oshchepkov;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ochchepkov.LSCommans.ILSCommand;
import com.ochchepkov.LSCommans.NoFlagCommand;

public class NoFlagCommandTest {
    
    @Test
    public void correctRequest(){
        ILSCommand r = new NoFlagCommand();
        assertTrue(r.apply("src").length() > 8 && r.apply("src").length() < 100);
    }
}
