package com.ochchepkov;

import java.util.List;

import com.ochchepkov.LSCommans.NoFlagCommand;
import com.ochchepkov.LSCommans.RecursiveFlag;

public class WorkingDirectory {

    private static volatile WorkingDirectory workingDirectory;
    private volatile StringBuilder path = new StringBuilder("src");

    private WorkingDirectory() {};
    private IComand command;

    public static WorkingDirectory getInstance() {
        if (workingDirectory == null){
            synchronized (WorkingDirectory.class) {
                if (workingDirectory == null) {
                    workingDirectory = new WorkingDirectory();
                }
            }
        }
        return workingDirectory;
    }

    public void invoke(IComand command) {
        this.command = command;
    }


    public void apply(String... arg) 
    {
        String responce;

        responce = command.apply(path, new List<String>());

        System.out.println(responce);
    }
}
