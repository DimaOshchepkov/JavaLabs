package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.oschepkov.BookstoreStruct.BookstoreXml;

public class DeserializerFromXml {
    XmlMapper xmlMapper = new XmlMapper();
    BookstoreXml apply(String path) throws IOException{
        File file = new File(path);
        return xmlMapper.readValue(file, BookstoreXml.class);
    }
}
