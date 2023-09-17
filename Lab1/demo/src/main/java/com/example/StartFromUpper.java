package com.example;

public class StartFromUpper implements IFormatStrategy {

    @Override
    public String format(String str) {
        StringBuilder sb = new StringBuilder(str);
        
        boolean isSpace = true;
        for (int i = 0; i < str.length(); i++) {
            if (sb.charAt(i) == ' ') {
                isSpace = true;
            }
            else { 
                if (isSpace) 
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                isSpace = false;
            }
        }
        return sb.toString();
    }
    
}
