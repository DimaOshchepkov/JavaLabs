package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.oschepkov.BookstoreStruct.BookstoreXml;


public class XML implements IReader, IWriter {

    XmlMapper xmlMapper = new XmlMapper();
    XML() {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /** 
     * @param path путь до файла для записи
     * @param obj объект для записи
     * @throws IOException
     */
    @Override
    public void write(String path, Object obj) throws IOException {
        
        xmlMapper.writeValue(new File(path), obj);
    }

    /** 
     * @param path путь до файла для считывания
     * @return BookstoreXml
     * @throws IOException
     */
    @Override
    public BookstoreXml read(String path) throws IOException {
        return xmlMapper.readValue(new File(path), BookstoreXml.class);
    }

}
