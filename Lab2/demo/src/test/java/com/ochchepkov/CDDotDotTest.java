package com.ochchepkov;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CDDotDotTest extends OutputRedirector{

    @Test
    void testApply() {
        String testPath = "src\\test\\resources\\testFolder";
        (new CDDotDot()).apply(testPath);

        assertTrue(testPath.contains("src\\test\\resources"));
        assertTrue(!testPath.contains("testFolder"));
    }
}
