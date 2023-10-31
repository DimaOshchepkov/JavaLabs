package com.ochchepkov.LSCommans;

import java.io.File;

public class RecursiveFlag implements ILSCommand{

    private static void listDirectories(File directory, StringBuilder response) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                response.append(file.getAbsolutePath() + "\n");
                if (file.isDirectory()) 
                    listDirectories(file, response); // Рекурсивный вызов для подкаталогов
            }
        }
    }

    @Override
    public String apply(String path) {
        StringBuilder response = new StringBuilder();
        listDirectories(new File(path), response);
        return response.toString();
    }
        
    
}

