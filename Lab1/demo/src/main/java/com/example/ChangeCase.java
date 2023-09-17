package com.example;

public class ChangeCase implements IFormatStrategy{

    @Override
    public String format(String str) {
       StringBuilder sb = new StringBuilder(str);

       for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(sb.charAt(i)))
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            else
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
       }
       return sb.toString();
    }
    
}
