package ru.oschepkov;

public class App {

    public static void main(String[] args) {
        try {
            if (args[0].endsWith(".xml")) 
                (new BookstoreConverterToJson()).convert(args[0], args[1]);
            else if (args[0].endsWith(".json")) {
                (new BookstoreConverterToXml()).convert(args[1], args[0]);
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
