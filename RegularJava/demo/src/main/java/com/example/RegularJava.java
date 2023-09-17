package com.example;

import java.util.regex.Pattern;

public class RegularJava {
    
    private static String patternIP = 
            "((0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))\\.){3}(0|1\\d{0,2}|2([0-4][0-9]|5[0-5]))";
    public boolean isIPAddress(String ip) {
        return Pattern.matches(patternIP, ip);
    }

    private static String patternGuid = 
          "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}";
    public boolean isGuid(String guid) {
        return Pattern.matches(patternGuid, guid);
    }

    private static String patternUrl =
            "^(https?:\\/\\/)?([\\da-z\\.]{2,})\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
    public Object isValidURL(String trueUrl) {
        return Pattern.matches(patternUrl, trueUrl);
    }

    
    


}
