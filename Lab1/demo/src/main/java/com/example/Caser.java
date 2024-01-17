package com.example;

public class Caser {
    public static Sentenceable ModeOfText(int mode){
        switch (mode){
            case 1 -> {
                return new ChangeLikeSentence();
            }
            case 2 -> {
                return new AllLowercase();
            }
            case 3 -> {
                return new AllUppercase();
            }
            case 4 -> {
                return new StartWithUppercase();
            }
            case 5 -> {
                return new ChangeCase();
            }
            default -> {
                return null;
            }
        }
    }
}
