package com.oshchepkov;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ochchepkov.LSCommans.ILSCommand;
import com.ochchepkov.LSCommans.RecursiveFlag;

public class RecursiveFlagTest {

    @Test
    public void correctRequest(){
        ILSCommand r = new RecursiveFlag();
        assertTrue(r.apply("src").length() > 100);
    }
}
