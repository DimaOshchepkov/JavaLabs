package com.ochchepkov;

import java.util.ArrayList;
import java.util.List;

public class WorkingDirectory {

    private static volatile WorkingDirectory workingDirectory;

    private WorkingDirectory() {};
    private List<IComand> commands = new ArrayList<IComand>();

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

    public <T, U> void invoke(IComand<T, U> command) {
        commands.add(command);
    }
    public
}
