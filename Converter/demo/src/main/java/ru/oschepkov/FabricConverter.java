package ru.oschepkov;

import java.io.FileReader;
import java.io.IOException;

public class FabricConverter {

    
    /** 
     * @param sourcePath путь до файла конвертации
     * Если файл .xml, то конвертер переводит .xml в .json,
     * иначе .json в .xml
     * @return IConverter
     * @throws IOException
     */
    public Converter create(String sourcePath) throws IOException {
        IReader reader;
        IWriter writer;
        try (FileReader r = new FileReader(sourcePath)) {
            int character = r.read();
            if (character == -1) {
                throw new IOException("Неизвестный тип файла");
            }
            char firstChar = (char) character;
            switch (firstChar) {
                case '<' -> {
                    reader = new XML();
                    writer = new JSON();
                }
                case '{' -> {
                    reader = new JSON();
                    writer = new XML();
                }
                default ->
                    throw new IOException("Неизвестный тип файла");
            }
        }
        return Converter.builder()
                .reader(reader)
                .writer(writer)
                .mapper(new MapperBookstore())
                .build();
    }
}
