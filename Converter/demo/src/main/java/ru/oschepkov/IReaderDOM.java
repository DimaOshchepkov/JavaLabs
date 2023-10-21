package ru.oschepkov;

import java.io.IOException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public interface IReaderDOM {
    Document read(String path) throws SAXException, IOException;
    
}
