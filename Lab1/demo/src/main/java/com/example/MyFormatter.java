package com.example;

public class MyFormatter {
    private IFormatStrategy formatStrategy = new Transliteration();

    public void setStrategy(IFormatStrategy strategy) {
        formatStrategy = strategy;
    }

    public String format(String str){
        return formatStrategy.format(str);
    }

    public String truncate(String str){
        return truncate(str, 9) ;
    }

    public String truncate(String str, int count){
        if (count  >= str.length())
            return str;
            
        while (count >= 0 && str.charAt(count) == ' ') 
            count--;

        return str.substring(0, count) + "...";
    }
}
