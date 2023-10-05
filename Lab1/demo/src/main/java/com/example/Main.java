package com.example;

public class Main {
    public static void main(String[] args) {

        MyFormatter formatter = new MyFormatter();
        System.out.println(formatter.format("Привет мир"));

        System.out.println(formatter.truncate("Привет мир", 5));

        formatter.setStrategy(new AsInSentences());
        System.out.println(formatter.format("4334dskjl, jsdlfj. adf. sd"));

        formatter.setStrategy(new ChangeCase());
        System.out.println(formatter.format("43JDSDLskjl, jsdlfj. adf. sd"));

        formatter.setStrategy(new LowerCase());
        System.out.println(formatter.format("43JDSDLskjl, jsdlfj. adf. sd"));

        formatter.setStrategy(new StartFromUpper());
        System.out.println(formatter.format("43JDSDLskjl, jsdlfj. adf. sd"));

        formatter.setStrategy(new UpperCase());
        System.out.println(formatter.format("43JDSDLskjl, jsdlfj. adf. sd"));
    }
}


