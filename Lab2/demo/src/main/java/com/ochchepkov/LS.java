package com.ochchepkov;

import java.io.File;
import java.util.Arrays;

public class LS implements ICommand {

    private WorkingDirectory wd = WorkingDirectory.getInstance();

    @Override
    public void apply() throws IllegalStateException {
        File directory = new File(wd.getPath());
        File[] files = directory.listFiles();

        if (files == null) 
            throw new IllegalStateException("No such directory");

        Arrays.stream(files)
                .map(File::getName)
                .forEach(System.out::println); 
    }  
}


