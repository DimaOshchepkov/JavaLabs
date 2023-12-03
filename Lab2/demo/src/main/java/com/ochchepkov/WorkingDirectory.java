package com.ochchepkov;

import java.util.List;

public class WorkingDirectory {

    private static volatile WorkingDirectory workingDirectory;
    private volatile String path = "src";

    private WorkingDirectory(String path) {
        this.path = path;
    }
    private ICommand command;

    public static WorkingDirectory getInstance(String path) {
        if (workingDirectory == null){
            synchronized (WorkingDirectory.class) {
                if (workingDirectory == null) {
                    workingDirectory = new WorkingDirectory(path);
                }
            }
        }
        return workingDirectory;
    }

    public void invoke(ICommand command) {
        this.command = command;
    }

    public void apply() {
        command.apply(path);
    }
}
