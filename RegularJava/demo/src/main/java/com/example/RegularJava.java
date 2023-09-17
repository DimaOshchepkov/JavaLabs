package com.example;

import java.util.regex.Pattern;

public class RegularJava {
    
    private static String pattern = "\\d{1,4}.\\d{1,4}.\\d{1,4}.\\d{1,4}";
    public boolean isIPAddress(String ip) {
        return Pattern.matches(ip, pattern);
    }
}
