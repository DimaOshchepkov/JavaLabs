package com.example;

public class ChangeLikeSentence implements Sentenceable{
    public String change(String input){
        StringBuffer str = new StringBuffer(input);

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) str.replace(i,i+1,str.substring(i,i+1).toUpperCase());
            else if (str.substring(i,i+1).equals(".") || str.substring(i,i+1).equals("!") || str.substring(i,i+1).equals("?")) {
                if (str.substring(i,i+1).equals(".")) while (str.substring(i+1,i+2).equals(".")) i++;
                if (str.substring(i+1,i+2).equals(" ")) i++;
                i++;
                str.replace(i,i+1,str.substring(i,i+1).toUpperCase());
            }
            else str.replace(i,i+1,str.substring(i,i+1).toLowerCase());
        }
        return str.toString();
    }
}