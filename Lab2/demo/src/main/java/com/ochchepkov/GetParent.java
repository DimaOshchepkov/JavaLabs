package com.ochchepkov;

import java.io.File;

public class GetParent implements ICommand{
    
    @Override
    public void apply(String filePath) throws IllegalArgumentException{
        File file = new File(filePath);
        File parentDirectory = file.getParentFile();
        
        if (parentDirectory == null) {
            throw new IllegalArgumentException("No parent directory");
        }
        if (!file.exists()){
           throw new IllegalArgumentException("No such directory");
        }
        System.out.println(parentDirectory);
    }
    
}
