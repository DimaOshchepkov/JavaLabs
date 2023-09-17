package com.example;

import java.util.regex.Pattern;

public class RegularJava {
    
    private static String pattern = "((0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))\\.){3}(0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))";
    public boolean isIPAddress(String ip) {
        return Pattern.matches(pattern, ip);
    }
}
