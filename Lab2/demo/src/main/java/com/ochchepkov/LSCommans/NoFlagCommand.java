package com.ochchepkov.LSCommans;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NoFlagCommand implements ILSCommand{

    @Override
    public String apply(String path) {
        return Arrays.stream(new File(path).listFiles())
                    .map(File::getName) // Преобразуем файлы в их имена
                    .collect(Collectors.joining("\n"));
    }
    
}
