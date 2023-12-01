package ru.oschepkov;

import java.io.IOException;

import lombok.Builder;
import ru.oschepkov.BookstoreNewStruct.YearsJson;
import ru.oschepkov.BookstoreStruct.BookstoreXml;

@Builder
public class Converter{
    
    IReader reader;
    IWriter writer;
    MapperBookstore mapper;

    public void convert(String sourcePath, String targetPath) throws IOException {
        Object obj = reader.read(sourcePath);
        switch (obj) {
            case BookstoreXml bookstore -> writer.write(targetPath, mapper.convert(bookstore));
            case YearsJson years -> writer.write(targetPath,  mapper.convert(years));
            default -> throw new IOException();
        }
    }
}
