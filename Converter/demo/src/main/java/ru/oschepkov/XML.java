package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.oschepkov.bookstore.BookstoreXml;
import ru.oschepkov.converterexeption.ReadFileException;
import ru.oschepkov.converterexeption.WriteFileException;

public class XML implements IReader, IWriter {

    XmlMapper xmlMapper = new XmlMapper();
    XML() {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /** 
     * @param path путь до файла для записи
     * @param obj объект для записи
     * @throws WriteFileException
     */
    @Override
    public void write(String path, Object obj) throws WriteFileException {
        try {
            xmlMapper.writeValue(new File(path), obj);
        }
        catch (IOException exception) {
            throw new WriteFileException("Ошибка записи в файл", exception);
        }
    }

    /** 
     * @param path путь до файла для считывания
     * @return BookstoreXml
     * @throws ReadFileException
     */
    @Override
    public BookstoreXml read(String path) throws ReadFileException {
        try {
            return xmlMapper.readValue(new File(path), BookstoreXml.class);
        }
        catch(IOException exception) {
            throw new ReadFileException("Ошибка чтения файла", exception);
        }
    }
}
