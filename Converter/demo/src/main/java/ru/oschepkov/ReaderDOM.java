package ru.oschepkov;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReaderDOM implements IReaderDOM{

    DocumentBuilderFactory factory;
    DocumentBuilder builder;

    ReaderDOM() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();    
    }

    @Override
    public Document read(String path) throws SAXException, IOException {
        return builder.parse(new File(path));
    }
    
}
