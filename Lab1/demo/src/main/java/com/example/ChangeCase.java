package com.example;
public class ChangeCase implements Sentenceable{
    public String change(String input){
        StringBuffer str = new StringBuffer(input);
        for (int i = 0;i < str.length(); i++){
            if (Character.isUpperCase(str.charAt(i))) str.replace(i,i+1,str.substring(i,i+1).toLowerCase());
            else if (Character.isLowerCase(str.charAt(i))) str.replace(i,i+1, str.substring(i,i+1).toUpperCase());

        }
        return str.toString();
    }
}