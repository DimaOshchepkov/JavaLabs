package com.example;

public class UpperCase implements IFormatStrategy {

    @Override
    public String format(String str) {
        return str.toUpperCase();
    }
    
}
