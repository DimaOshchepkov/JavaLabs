package com.ochchepkov;

import java.io.File;
import java.util.Arrays;

public class LS implements ICommand {

    @Override
    public void apply(String path) throws IllegalArgumentException {
        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files == null) 
            throw new IllegalArgumentException("No such directory");

        Arrays.stream(files)
                .map(File::getName)
                .forEach(System.out::println); 
    }  
}

    
