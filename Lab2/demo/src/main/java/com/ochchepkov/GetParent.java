package com.ochchepkov;

import java.io.File;

public class GetParent implements ICommand{
    
    private WorkingDirectory wd = WorkingDirectory.getInstance();

    @Override
    public void apply() throws IllegalStateException{
        File file = new File(wd.getPath());
        File parentDirectory = file.getParentFile();
        
        if (parentDirectory == null) {
            throw new IllegalStateException("No parent directory");
        }
        if (!file.exists()){
           throw new IllegalStateException("No such directory");
        }
        System.out.println(parentDirectory);
    }
    
}
