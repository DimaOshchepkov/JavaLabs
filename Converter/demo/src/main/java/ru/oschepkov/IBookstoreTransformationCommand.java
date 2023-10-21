package ru.oschepkov;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public interface IBookstoreTransformationCommand {
    Document invoke(Document document) throws ParserConfigurationException;
}
