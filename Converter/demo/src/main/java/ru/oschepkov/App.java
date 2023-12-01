package ru.oschepkov;

public class App {

    public static void main(String[] args) { 
        FabricConverter fabric = FabricConverter.getInstance();     
        try {
            Converter converter = fabric.create(args[0]);
            converter.convert(args[0], args[1]);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }  
}
