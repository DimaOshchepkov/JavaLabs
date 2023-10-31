package com.ochchepkov;

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
