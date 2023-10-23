package com.ochchepkov;

public class TestCommand implements IComand<String, Integer> {

    @Override
    public String apply(Integer value) {
        return "hello";
    }
    
}
