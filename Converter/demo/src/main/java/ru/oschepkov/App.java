package ru.oschepkov;

import org.apache.log4j.PropertyConfigurator;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(final String[] args) { 
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
        val fabric = FabricConverter.getInstance();     
        try {
            Converter converter;
            if (args.length == 2)
                converter = fabric.create(args[0]);
            else if (args.length == 4)
                converter = fabric.create(args[0], args[2], args[3]);
            else
                throw new IllegalArgumentException("Неверное количество аргументов");
                
            converter.convert(args[0], args[1]);
        } catch (final Exception exception) {
            System.out.println(exception.getMessage());
            log.error(exception.getMessage(), exception);
        }
    }  
}
