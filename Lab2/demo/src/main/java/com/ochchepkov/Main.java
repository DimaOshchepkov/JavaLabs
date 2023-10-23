package com.ochchepkov;

public class Main {
    public static void main(String[] args) {
        
        WorkingDirectory workingDirectory = WorkingDirectory.getInstance();
        IComand c = new TestCommand();
        System.out.println(workingDirectory.invoke(c));
    }
}