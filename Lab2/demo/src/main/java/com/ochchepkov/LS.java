package com.ochchepkov;

<<<<<<< HEAD
import java.util.List;

import com.ochchepkov.LSCommans.ILSCommand;
import com.ochchepkov.LSCommans.NoFlagCommand;
import com.ochchepkov.LSCommans.RecursiveFlag;

public class LS implements IComand {

    @Override
    public String apply(StringBuilder path, List<String> arg) {
        ILSCommand flag;
        // TODO: bad realizations. Mybe factory or command
        if (arg.contains("-R"))
            flag = new RecursiveFlag();
        else
            flag = new NoFlagCommand();
        return flag.apply(path.toString());
    }
    
}
=======
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

    
>>>>>>> lab2
