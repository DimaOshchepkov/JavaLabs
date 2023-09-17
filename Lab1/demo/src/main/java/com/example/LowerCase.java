package com.example;

public class LowerCase implements IFormatStrategy {
    @Override
    public String format(String str) {
        return str.toLowerCase();
    }
    
}
