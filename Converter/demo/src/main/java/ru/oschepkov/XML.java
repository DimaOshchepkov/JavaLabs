package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.oschepkov.BookstoreStruct.BookstoreXml;


public class XML implements IReader, IWriter {
    
    ObjectMapper objectMapper = new ObjectMapper();
    
    /** 
     * @param path путь до файла *.json, в которых будет записан объект
     * @param obj объект для записи
     * @throws IOException
     */
    @Override
    public void write(String path, Object obj) throws IOException {
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new File(path), obj);
    }

    XmlMapper xmlMapper = new XmlMapper();
    /** 
     * @param path путь до файла *.xml для считывания
     * @return BookstoreXml
     * @throws IOException
     */
    @Override
    public BookstoreXml read(String path) throws IOException {
        return xmlMapper.readValue(new File(path), BookstoreXml.class);
    }

}
