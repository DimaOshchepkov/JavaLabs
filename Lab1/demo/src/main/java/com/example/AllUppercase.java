package com.example;

public class AllUppercase implements Sentenceable{
    public String change(String input){
        StringBuffer str = new StringBuffer(input);
        for (int i = 0; i < str.length(); i++) str.replace(i, i + 1, str.substring(i,i+1).toUpperCase());
        return str.toString();
    }
}