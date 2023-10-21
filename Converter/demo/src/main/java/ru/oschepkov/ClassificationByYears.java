package ru.oschepkov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ClassificationByYears implements IBookstoreTransformationCommand {

    @Override
    public Document invoke(Document document) throws ParserConfigurationException {
        Map<String, List<Element>> booksByYear = groupBooksByYear(document);

        // Создаем новый документ
        return createNewDocument(booksByYear);
    }

    private Map<String, List<Element>> groupBooksByYear(Document document) {
        Map<String, List<Element>> booksByYear = new HashMap<>();

        NodeList books = document.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String year = book.getElementsByTagName("year").item(0).getTextContent();

            List<Element> booksForYear = booksByYear.getOrDefault(year, new ArrayList<>());
            booksForYear.add(book);
            booksByYear.put(year, booksForYear);
        }

        return booksByYear;
    }

    public static Document createNewDocument(Map<String, List<Element>> booksByYear) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document newDocument = builder.newDocument();
    
        Element rootElement = newDocument.createElement("books_by_year");
        newDocument.appendChild(rootElement);
    
        for (Map.Entry<String, List<Element>> entry : booksByYear.entrySet()) {
            String year = entry.getKey();
            List<Element> books = entry.getValue();
    
            Element yearElement = newDocument.createElement("year");
            yearElement.setAttribute("value", year);
    
            for (Element book : books) {
                // Импортируем узел из исходного документа в новый
                Node importedBook = newDocument.importNode(book, true);
                yearElement.appendChild(importedBook);
            }
    
            rootElement.appendChild(yearElement);
        }
    
        return newDocument;
    }

}
