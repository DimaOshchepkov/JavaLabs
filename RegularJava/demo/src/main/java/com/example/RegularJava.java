package com.example;

import java.util.regex.Pattern;

public class RegularJava {
    
    private static String patternIP = 
            "((0|1\\d{0,2}|\\d{1,2}|2([0-4][0-9]|5[0-5]))\\.){3}(0|1\\d{0,2}|\\d{1,2}|2([0-4][0-9]|5[0-5]))";
    public boolean isIPAddress(String ip) {
        return Pattern.matches(patternIP, ip);
    }

    private static String patternGuid = 
          "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}";
    public boolean isGuid(String guid) {
        return Pattern.matches(patternGuid, guid);
    }

    private static String patternUrl =
            "^(https?:\\/\\/)?([\\da-z\\.]{2,})\\.([a-z\\.]{2,6})([\\/\\w\\S \\.-]*)*\\/?$";
    public boolean isValidURL(String url) {
        return Pattern.matches(patternUrl, url);
    }

    private static String patternCountAndSizeOfPass = 
            "[a-zA-Z0-9_]{8,}";
    private static String patternOneDigit = ".*\\d.*";
    private static String patternUpperCase = ".*[A-Z].*";
    private static String patternLowerCase = ".*[a-z].*";
    public boolean isStrongPassord(String password) {
        return Pattern.matches(patternCountAndSizeOfPass, password) &&
               Pattern.matches(patternOneDigit, password) &&
               Pattern.matches(patternUpperCase, password) &&
               Pattern.matches(patternLowerCase, password);
    }
}
