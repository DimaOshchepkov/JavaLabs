package com.ochchepkov;

public class WorkingDirectory {

    private static WorkingDirectory workingDirectory;
    private static String path;
    private ICommand command;

    public String getPath() throws IllegalStateException {
        if (path == null) {
            throw new IllegalStateException("Working directory is not set"); 
        }
        return path;
    }

    private WorkingDirectory(String path) {
        WorkingDirectory.path = path;
    }
    
    public static WorkingDirectory getInstance(String path) {
        if (workingDirectory == null){
            workingDirectory = new WorkingDirectory(path);
        }
        WorkingDirectory.path = path;
        return workingDirectory;
    }
        
    public static WorkingDirectory getInstance() throws IllegalStateException{
        if (workingDirectory == null) {
            throw new IllegalStateException("Working directory is not set");
        }
        return WorkingDirectory.getInstance(path);
    }

    public void invoke(ICommand command) {
        this.command = command;
    }

    public void apply() {
        command.apply();
    }
}
